package mylib

import spinal.core._
import spinal.lib._

class PcReg extends Component {
  val io = new Bundle {
    val pc = out UInt (6 bits)
    val ce = out Bool ()
  }

  val ceReg = Reg(Bool()) init (False)
  ceReg := True

  val pcReg = Reg(UInt(6 bits)) init (0)
  when(ceReg)(
    pcReg := pcReg + 1
  ) otherwise (
    pcReg := 0
  )

  io.ce := ceReg
  io.pc := pcReg

}

//Generate the MyTopLevel's Verilog using the above custom configuration.
object PecRegVerilog {
  def main(args: Array[String]) {
    MySpinalConfig.generateVerilog(new PcReg)
  }
}
