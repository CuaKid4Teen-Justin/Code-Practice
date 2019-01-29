/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static TalonSRX m_rightMaster;
  public static TalonSRX m_rightMiddle;
  public static TalonSRX m_rightBack;

  public static TalonSRX m_leftMaster;
  public static TalonSRX m_leftMiddle;
  public static TalonSRX m_leftBack;
  //can use comma instead of creating more lines
  
public Drive (){
  //oiuawhyfoiqfywag
   m_leftMaster = new TalonSRX (RobotMap.m_leftMaster);
  m_leftMiddle = new TalonSRX (RobotMap.m_leftMiddle);
  m_leftBack = new TalonSRX (RobotMap.m_leftBack);

   m_rightMaster = new TalonSRX (RobotMap.m_rightMaster);
  m_rightMiddle = new TalonSRX (RobotMap.m_rightMiddle);
  m_rightBack = new TalonSRX (RobotMap.m_rightBack);

  m_leftMiddle.follow(m_leftMaster);
  m_leftBack.follow(m_leftMaster);

  m_rightBack.follow(m_rightMaster);
  m_rightMiddle.follow(m_rightMaster);

  }

  //double is decimal, int is a whole number
public double getRightPosition (){
    return m_rightMaster.getSelectedSensorPosition();
}

public double getLeftPosition (){
    return m_leftMaster.getSelectedSensorPosition();
}

public double getAveragePosition (){
    return getLeftPosition() + getRightPosition() / 2;
  
}

public void setPower (double RightPow, double LeftPow){

  m_leftMaster.set(ControlMode.PercentOutput, LeftPow);
  m_leftMiddle.set(ControlMode.PercentOutput, LeftPow);
  m_leftBack.set(ControlMode.PercentOutput, LeftPow);

  m_rightMaster.set(ControlMode.PercentOutput, RightPow);
  m_rightMiddle.set(ControlMode.PercentOutput, RightPow);
  m_rightBack.set(ControlMode.PercentOutput, RightPow);

}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
