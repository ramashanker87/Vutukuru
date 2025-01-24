package Custom;

public class TestingAgeForVote {
    public static void main(String[] args) {
        TestingAgeForVote test=new TestingAgeForVote();
        try{
            test.validateAge(16);
        }catch(RevanthAgeValidationException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            System.out.println("This is executed");
        }
    }

    public void validateAge(int age) throws RevanthAgeValidationException {
        if (age <=18) {
            throw new RevanthAgeValidationException("Age must be above 18 to vote.");
        }
    }
}
