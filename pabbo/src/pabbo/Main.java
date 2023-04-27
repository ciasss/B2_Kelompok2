package pabbo;

//import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;
import java.util.Arrays;
import java.util.StringTokenizer; //https://www.termasmedia.com/pemrograman/java/166-menggunakan-kelas-stringtokenizer-di-java.html

public class Main {

    //    static int kode = 0;
    static String pilihMenu, nama, ttl, noTelp, alamat, username, pass, konfirPass;
    static Scanner inputData = new Scanner(System.in);
    static Scanner inputDataNext = new Scanner(System.in);
    static Scanner inputInt = new Scanner(System.in);
    static admin dataAdm = new admin();
    static ArrayList<pasien> arrPasien = new ArrayList<>();
    
    static ArrayList<dokter> arrDokter = new ArrayList<>();
    static ArrayList<janjiTemu> arrJanjiTemu = new ArrayList<>();

    static boolean newAkun(String newUsername, pasien newData) {
        for (int i = 0; i < arrPasien.size(); i++) {
            if (arrPasien.get(i).getUsername().equals(newUsername)) {
                return false;
            }
        }
        arrPasien.add(newData);
        return true;
    }

    static void buatAkun() {
        pasien newData = new pasien(null, null, null, null, null, null);
        while (true) {
            System.out.println("===========================================");
            System.out.println("               REGISTRASI AKUN             ");
            System.out.println("===========================================");
            System.out.print("       Nama Lengkap : ");
            nama = inputDataNext.nextLine();
            do {
                try {
                    System.out.print("       TTL          : ");
                    newData.setTTL(inputData.next());
                } catch (InvalidTTLException invalidTTL) {
                    System.out.print(invalidTTL.toString());
                    System.out.print("Masukkan TTL dengan format \"DD/MM/YYYY\".\n");
                }
            } while (newData.getTTL() == null);

            int data;
            while (true) {
                try {
                    System.out.print("       No Telpon    : ");
                    noTelp = inputData.next();
                    data = Integer.parseInt(noTelp);
                    if (data > 0) {
                        break;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("\tNomor telepon yang dimasukkan tidak sesuai!");
                }
            }
            System.out.print("       Alamat       : ");
            alamat = inputDataNext.nextLine();
            System.out.print("       Username     : ");
            username = inputData.next();
            System.out.print("       Password     : ");
            pass = inputData.next();
            while (true) {
                System.out.print("Konfirmasi Password : ");
                konfirPass = inputData.next();
                if (pass.equals(konfirPass)) {
                    if (newAkun(username, new pasien(username, pass, nama, ttl, noTelp, alamat)) == true) {
                        System.out.println("===========================================");
                        System.out.println("\tBerhasil membuat akun...");
                        return;
                    } else {
                        System.out.println("===========================================");
                        System.out.println("username telah digunakan!");
                        break;
                    }
                } else {
                    System.out.println("===========================================");
                    System.out.println("Password tidak sesuai!");
                }
            }
        }
    }

    static int login(String username, String password) {
        for (int i = 0; arrPasien.size() > i; i++) {
            if (arrPasien.get(i).getUsername().equals(username) && arrPasien.get(i).getPass().equals(password)) {
                return i;
            }
        }
        return -1;
    }

    static void login() throws IOException {
        while (true) {
            System.out.println("===========================================");
            System.out.println("                    LOGIN                  ");
            System.out.println("===========================================");
            System.out.print("Masukkan username : ");
            username = inputData.next();
            System.out.print("Masukkan password : ");
            pass = inputData.next();
            System.out.println("===========================================");

            if (dataAdm.login(username, pass) == true) {
                System.out.println("===========================================");
                System.out.println("                  MENU ADMIN               ");
                System.out.println("===========================================");
                if (dataAdm.login() == 0) {
                    break;
                }
            } else if (login(username, pass) != -1) {
                 System.out.println("===========================================");
                 System.out.println("                 MENU PASIEN               ");
                 System.out.println("===========================================");
                if (arrPasien.get(login(username, pass)).login() == 0) {
                    break;
                }
            } else {
                System.out.println("username atau kata sandi salah!");
                while (true) {
                    System.out.println("1. Coba Lagi");
                    System.out.println("2. Kembali ke Menu Awal");
                    System.out.println("===========================================");
                    System.out.println("Masukkan Pilihan : ");
                    pilihMenu = inputData.next();
                    if (pilihMenu.equals("1")) {
                        break;
                    } else if ((pilihMenu.equals("2"))) {
                        return;
                    } else {
                        System.out.println("Inputan Salah!");
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("===========================================");
            System.out.println("SELAMAT DATANG DI PROGRAM JANJI TEMU DOKTER");
            System.out.println("===========================================");
            System.out.println("[1] login");
            System.out.println("[2] buat akun");
            System.out.println("[3] end progam");
            System.out.println("===========================================");
            System.out.print("\tMasukkan Pilihan: ");
            pilihMenu = inputData.next();
            if (pilihMenu.equalsIgnoreCase("1")) {
                login();
            } else if (pilihMenu.equalsIgnoreCase("2")) {
                buatAkun();
            } else if (pilihMenu.equalsIgnoreCase("3")) {
                break;
            } else {
                System.err.println("Pilih menu 1-3!");
            }
        }
    }
}
