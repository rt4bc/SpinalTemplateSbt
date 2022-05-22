package mylib

import spinal.core._
import spinal.lib._

import scala.io.Source

class Rom extends Component {
  val io = new Bundle {
    val ce = in Bool ()
    val addr = in UInt (6 bits)
    val reg = out UInt (32 bits)
  }

  // val mem = Mem(UInt(32 bits), wordCount = 64)
  val romTable = Array(
    // index 0
    U"32'h0",
    U"32'h1",
    U"32'h2",
    U"32'h3",
    U"32'h4",
    U"32'h5",
    U"32'h6",
    U"32'h7",
    // index 8
    U"32'h0",
    U"32'h1",
    U"32'h2",
    U"32'h3",
    U"32'h4",
    U"32'h5",
    U"32'h6",
    U"32'h7",
    // index 16
    U"32'h0",
    U"32'h1",
    U"32'h2",
    U"32'h3",
    U"32'h4",
    U"32'h5",
    U"32'h6",
    U"32'h7",
    // index 32
    U"32'h0",
    U"32'h1",
    U"32'h2",
    U"32'h3",
    U"32'h4",
    U"32'h5",
    U"32'h6",
    U"32'h7",
    // index 40
    U"32'h0",
    U"32'h1",
    U"32'h2",
    U"32'h3",
    U"32'h4",
    U"32'h5",
    U"32'h6",
    U"32'h7",
    // index 48
    U"32'h0",
    U"32'h1",
    U"32'h2",
    U"32'h3",
    U"32'h4",
    U"32'h5",
    U"32'h6",
    U"32'h7",
    // index 56
    U"32'h0",
    U"32'h1",
    U"32'h2",
    U"32'h3",
    U"32'h4",
    U"32'h5",
    U"32'h6",
    U"32'h7",
    // index 64
    U"32'h0",
    U"32'h1",
    U"32'h2",
    U"32'h3",
    U"32'h4",
    U"32'h5",
    U"32'h6",
    U"32'h7"
  )
  val mem = Mem(UInt(32 bits), initialContent = romTable)

  when(io.ce) {
    // io.reg := mem.apply(io.addr)
    io.reg := mem(io.addr)
  } otherwise {
    io.reg := 0
  }
}

//Generate the MyTopLevel's Verilog using the above custom configuration.
object RomVerilogWithCustomConfig {
  def main(args: Array[String]) {
    MySpinalConfig.generateVerilog(new Rom)
  }
}
