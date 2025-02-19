/*
Question 5: Student Pass/Fail Status with Nested Switch
Write a program that determines whether a student passes or fails based on their grades in three
subjects. If the student scores more than 40 in all subjects, they pass. If the student fails in one or
more subjects, print the number of subjects they failed in.
*/


import java.util.*;
class FailOrPass {
    public static void main(String[] args) {
        Scanner obj= new Scanner(System.in);
        System.out.print("Enter marks for Marathi: ");
        int sub1 = obj.nextInt();

        System.out.print("Enter marks for Hindi: ");
        int sub2 = obj.nextInt();

        System.out.print("Enter marks for English: ");
        int sub3 = obj.nextInt();
        int failedCount = 0;
	if(sub1<40){
		failedCount++;
	}
	if(sub2<40){
		failedCount++;
	}
	if(sub3<40){
		failedCount++;
	}
        switch (failedCount) {
            case 0:
                System.out.println("Student has passed.");
                break;
            default:
                switch (failedCount) {
                    case 1:
                        System.out.println("Failed in 1 subject");
                        break;
                    case 2:
                        System.out.println("Failed in 2 subjects");
                        break;
                    case 3:
                        System.out.println("Failed in all subjects");
                        break;
                }
                break;
        }

    }
}