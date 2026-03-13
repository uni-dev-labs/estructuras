package arrays;

import arrays.models.Employer;

public class ArrayPersons {
    public static void main(String[] args) {
        Employer[] employers = new Employer[5];
        loadEmployers(employers);
        // printEmployers(employers);

        employers[0] = new Employer("1234567890", "Juan", "Perez", 'M', new String[] {"ingeniero", "programador", "analista", "diseñador", "tester"});

        getTitleForIndex(employers[0], 2);
        getTitleForIndex(employers[1], 3);
    }

    public static void loadEmployers(Employer[] employers) {
        employers[1] = new Employer("manuel", "castro");
        employers[2] = new Employer();
        employers[3] = new Employer("1234567891", "Maria", "Gomez", 'F', new String[] {"diseñadora", "programadora", "analista", "diseñadora", "tester"});
        employers[4] = new Employer("1234567891", "Maria", "Gomez", 'F', new String[] {"diseñadora", "programadora", "analista", "diseñadora", "tester"});
    }


    public static void printEmployers(Employer[] employers) {
        for (Employer employer : employers) {
            System.out.println("-------------- + ---------------");
            employer.printEmployer();
            System.out.println("-------------- - ---------------");
        }
    }

    public static void getTitleForIndex(Employer employer, int index_title) {
        if (employer == null) {
            System.out.println("Employer no encontrado (null)");
            return;
        }
        System.out.println("Título para el índice " + index_title + ": " + employer.getIndividualTitle(index_title));
        System.out.println("-------------- + ---------------");
    }
}
