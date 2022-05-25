package mylib

import spinal.core._
import spinal.lib._

import scala.io.Source

class Rom extends Component {
  val io = new Bundle {
    val ce = in Bool ()
    val addr = in UInt (6 bits)
    val reg = out Bits (32 bits)
  }

  // val mem = Mem(UInt(32 bits), wordCount = 64)
  val romTable = Array(
    // index 0
    B"32'h0",
    B"32'h1",
    B"32'h2",
    B"32'h3",
    B"32'h4",
    B"32'h5",
    B"32'h6",
    B"32'h7",
    // index 8
    B"32'h0",
    B"32'h1",
    B"32'h2",
    B"32'h3",
    B"32'h4",
    B"32'h5",
    B"32'h6",
    B"32'h7",
    // index 16
    B"32'h0",
    B"32'h1",
    B"32'h2",
    B"32'h3",
    B"32'h4",
    B"32'h5",
    B"32'h6",
    B"32'h7",
    // index 32
    B"32'h0",
    B"32'h1",
    B"32'h2",
    B"32'h3",
    B"32'h4",
    B"32'h5",
    B"32'h6",
    B"32'h7",
    // index 40
    B"32'h0",
    B"32'h1",
    B"32'h2",
    B"32'h3",
    B"32'h4",
    B"32'h5",
    B"32'h6",
    B"32'h7",
    // index 48
    B"32'h0",
    B"32'h1",
    B"32'h2",
    B"32'h3",
    B"32'h4",
    B"32'h5",
    B"32'h6",
    B"32'h7",
    // index 56
    B"32'h0",
    B"32'h1",
    B"32'h2",
    B"32'h3",
    B"32'h4",
    B"32'h5",
    B"32'h6",
    B"32'h7",
    // index 64
    B"32'h0",
    B"32'h1",
    B"32'h2",
    B"32'h3",
    B"32'h4",
    B"32'h5",
    B"32'h6",
    B"32'h7"
  )
  val mem = Mem(Bits(32 bits), initialContent = romTable)

  when(io.ce) {
    // io.reg := mem.apply(io.addr)
    io.reg := mem(io.addr)
  } otherwise {
    io.reg := 0
  }
}

//Generate the MyTopLevel's Verilog using the above custom configuration.
object RomVerilog {
  def main(args: Array[String]) {
    MySpinalConfig.generateVerilog(new Rom)
  }
}
