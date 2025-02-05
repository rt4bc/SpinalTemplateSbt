/*
 * SpinalHDL
 * Copyright (c) Dolu, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package mylib

import spinal.core._
import spinal.lib._

/*
 * Define a custom SpinalHDL configuration with synchronous reset
 * instead of the default asynchronous one. This configuration can be
 * resued everywhere.
 */
object MySpinalConfig
    extends SpinalConfig(
      targetDirectory = "./hdl/src",
      defaultConfigForClockDomains =
        ClockDomainConfig(resetKind = SYNC, resetActiveLevel = HIGH)
    )

//Hardware definition
class MyTopLevel extends Component {

  val io = new Bundle {
    val state = out Bool()
  }

  val state = Reg(Bool()) init(False)
  io.state := state

  val subPcReg = new PcReg()
  val subRom = new Rom()

  subRom.io.ce := subPcReg.io.ce
  subRom.io.addr := subPcReg.io.pc

}

//Generate the MyTopLevel's Verilog using the above custom configuration.
object MyTopLevelVerilog {
  def main(args: Array[String]) {
    MySpinalConfig.generateVerilog(new MyTopLevel)
  }
}
