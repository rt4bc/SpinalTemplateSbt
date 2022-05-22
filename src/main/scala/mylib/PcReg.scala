package mylib

import spinal.core._
import spinal.lib._

class PcReg extends Component {
  val io = new Bundle {

    val pc = out UInt (6 bits)
    val ce = out Bool ()
  }

  val pcReg = Reg(UInt(6 bits)) init (0)
  pcReg := pcReg + 1
  io.pc := pcReg

  val ceReg = Reg(Bool()) init (False)
  ceReg := True
  io.ce := ceReg
}

// object MySpinalConfig
// extends SpinalConfig(
// targetDirectory = "./hdl/src"
// )

//Generate the MyTopLevel's Verilog using the above custom configuration.
object PecRegVerilogWithCustomConfig {
  def main(args: Array[String]) {
    MySpinalConfig.generateVerilog(new PcReg)
  }
}
