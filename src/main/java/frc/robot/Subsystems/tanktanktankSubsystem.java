package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class tanktanktankSubsystem extends SubsystemBase {
//    Joystick m_leftStick = new Joystick(0);
//    Joystick m_rightStick = new Joystick(1);
    private TalonSRX frontleft = new TalonSRX(12);
    private TalonSRX backleft = new TalonSRX(13);
//    backleft.follow(frontleft);
    private TalonSRX frontright = new TalonSRX(10);
    private TalonSRX backright = new TalonSRX(11);

    public tanktanktankSubsystem() {
        super();
        backleft.follow(frontleft);
        backright.follow(frontright);
    }

    public void drive(double left, double right) {
        frontleft.set(TalonSRXControlMode.PercentOutput, left);
        frontright.set(TalonSRXControlMode.PercentOutput, -right);

    }
    @Override
    public void periodic() {

        //this method will be called once per scheduler run
    }
    @Override
    public void simulationPeriodic() {
        //will be called once per scheduler run during simulation
    }
}
