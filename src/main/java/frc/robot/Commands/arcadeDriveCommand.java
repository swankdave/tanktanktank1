package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.tanktanktankSubsystem;

import static java.lang.Math.abs;

public class arcadeDriveCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final tanktanktankSubsystem _tanktanktanksubsystem;
    private final Joystick leftStick;
    private final Joystick rightStick;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public arcadeDriveCommand(tanktanktankSubsystem subsystem, Joystick leftstick, Joystick rightstick) {
        _tanktanktanksubsystem = subsystem;
        leftStick = leftstick;
        rightStick = rightstick;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);

    }
    @Override
    public void initialize(){

    }

    @Override
    public void execute() {
        double throttle = leftStick.getY();
        double yaw = rightStick.getX();

        double leftspeed = 0;
        double rightspeed = 0;

        if(yaw<0) {
            leftspeed=throttle*(1-abs(yaw));
            rightspeed=throttle;
        } else if(yaw>0){
            leftspeed=throttle;
            rightspeed=throttle*(1-yaw);
        }

        _tanktanktanksubsystem.drive(leftspeed,rightspeed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

//    @Override
//    public void end() {
//
//    }



}
