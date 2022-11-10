package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class tanktanktankSubsystem extends SubsystemBase {
//    Joystick m_leftStick = new Joystick(0);
//    Joystick m_rightStick = new Joystick(1);
    private VictorSPX frontleft = new VictorSPX(12);
    private VictorSPX backleft = new VictorSPX(13);
//    backleft.follow(frontleft);
    private VictorSPX frontright = new VictorSPX(10);
    private VictorSPX backright = new VictorSPX(11);

    public tanktanktankSubsystem() {
        super();
        backleft.follow(frontleft);
        backright.follow(frontright);
    }

    public void drive(double left, double right) {
        frontleft.set(VictorSPXControlMode.PercentOutput, left);
        frontright.set(VictorSPXControlMode.PercentOutput, -right);

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
