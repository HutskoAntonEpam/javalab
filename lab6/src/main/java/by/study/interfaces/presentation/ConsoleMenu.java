package by.study.interfaces.presentation;

import by.study.interfaces.service.data.Doctor;
import by.study.interfaces.service.data.Neurosurgeon;
import by.study.interfaces.service.data.Surgeon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleMenu {
    Logger log = LogManager.getLogger(ConsoleMenu.class.getName());

    public static void main(String[] args) {
        ConsoleMenu console = new ConsoleMenu();
        console.show();
    }

    private void show(){
        Doctor[] doctors = new Doctor[3];
        doctors[0] = new Neurosurgeon("Neuro1", 80);
        doctors[1] = new Surgeon("Usual", 10);
        doctors[2] = new Neurosurgeon("Neuro2", 65);

        System.out.println("Lab6. Interfaces\n-------\nDoctors:");
        for (Doctor doctor: doctors) {
            System.out.println(doctor.getName() + ": " + doctor.getDoctorType());
        }

        System.out.println("\nSurgeries:");
        for( Doctor doctor: doctors) {
            System.out.println(doctor.getName() + " surgeon: " + doctor.getSurgeryResult());
        }
        System.out.println("-------");
    }
}
