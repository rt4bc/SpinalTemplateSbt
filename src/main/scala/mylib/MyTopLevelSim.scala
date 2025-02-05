package mylib

import spinal.core._
import spinal.lib._
import spinal.sim._
import spinal.core.sim._

import scala.util.Random


//MyTopLevel's testbench
object MyTopLevelSim {
  def main(args: Array[String]) {
    // SimConfig.withWave.doSim(new MyTopLevel){dut =>
    SimConfig.withWave.doSim(  MySpinalConfig.generateVerilog(new MyTopLevel)){dut =>
      //Fork a process to generate the reset and the clock on the dut
      dut.clockDomain.forkStimulus(period = 10)
      for(idx <- 0 to 100){
        //Wait a rising edge on the clock
        dut.clockDomain.waitEdge()
      }
    }
  }
}
