import application.EodUseCase;
import application.EodUseCaseImpl;

public class AlamiCodingProject {
    public static void main(String args[]) {
        EodUseCase eodUseCase = new EodUseCaseImpl();

        eodUseCase.executeEodTask(args[0], args[1]);
    }
}
