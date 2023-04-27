package pabbo;

import java.io.*;
import java.util.*;
import java.time.Year;
import static pabbo.Main.inputData;
import static pabbo.Main.inputDataNext;
import static pabbo.Main.inputInt;
import static pabbo.Main.arrJanjiTemu;
import static pabbo.Main.inputData;
import static pabbo.Main.noTelp;

public class admin extends user implements menuUser{

    public admin() {
        super("admin", "admin");
    }
    boolean login(String usernameAdm, String passAdm) {
        return super.getUsername().equals(usernameAdm) && super.getPass().equals(passAdm);
    }

    @Override
    int login() throws IOException{
        System.out.println("Selamat Datang Admin!");
        return menu();
    }
    
    @Override
    public int menu() throws IOException{
        Scanner terminalInput = new Scanner(System.in);
        String pilihanUser;
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            clearScreen();
            System.out.print("\n\n");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
            System.out.println("          || SISTEM || JANJI TEMU || RUMAH SAKIT ||             ");
            System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                    "██ ▄▄▀██ ██ ██ ▄▀▄ █ ▄▄▀██ ██ ████ ▄▄▄ █ ▄▄▀██ █▀▄█▄ ▄█▄▄ ▄▄██\n" +
                    "██ ▀▀▄██ ██ ██ █ █ █ ▀▀ ██ ▄▄ ████▄▄▄▀▀█ ▀▀ ██ ▄▀███ ████ ████\n" +
                    "██ ██ ██▄▀▀▄██ ███ █ ██ ██ ██ ████ ▀▀▀ █ ██ ██ ██ █▀ ▀███ ████\n" +
                    "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
            System.out.println("    [1]\tLihat Seluruh Jadwal Dokter");
            System.out.println("    [2]\tCari Jadwal Dokter");
            System.out.println("    [3]\tTambah Jadwal Dokter");
            System.out.println("    [4]\tUbah Jadwal Dokter");
            System.out.println("    [5]\tHapus Jadwal Dokter");
            System.out.println("    [6]\tLogout\n");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
            System.out.print("Pilih : ");
            pilihanUser = terminalInput.next();
            System.out.print("\n\n");


            switch (pilihanUser) {
                case "1":
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
                    System.out.println("                    LIAT SELURUH JADWAL DOKTER                  ");
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
                    tampilkanData();
                    break;
                case "2":
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
                    System.out.println("                      CARI JADWAL DOKTER                        ");
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
                    cariData();
                    break;
                case "3":
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
                    System.out.println("                     TAMBAH JADWAL DOKTER                       ");
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
                    tambahData();
                    tampilkanData();
                    break;
                case "4":
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
                    System.out.println("                       UBAH JADWAL DOKTER                       ");
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
                    updateData();
                    break;
                case "5":
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
                    System.out.println("                       HAPUS JADWAL DOKTER                    ");
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
                    deleteData();
                    break;
                case "6":
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
                    System.out.println("                       LOGOUT                   ");
                    System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
                    return 0;
                default:
                    System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih [1-6]");
            }

            isLanjutkan = getYesorNo("   Apakah anda ingin melanjutkan ? ");
        }
        return 0;
    }

    private static void updateData() throws IOException {
        // database original
        File tempDB = new File("tempDB.txt");
        FileReader fileInput = new FileReader(tempDB);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // database sementara
        File database = new File("database.txt");
        FileWriter fileOutput = new FileWriter(database);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
//        System.out.println("Liat Jadwal");
//        tampilkanData();

        // ambil admin input / pilihan data
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("\nMasukkan no jadwal yang akan di update : ");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
        int updateNum = terminalInput.nextInt();

        // tampilkan data yang ingin diupdate
        String data = bufferedInput.readLine();
        int entryCounts = 0;

        while (data != null) {
            entryCounts++;

            StringTokenizer st = new StringTokenizer(data, ",");
            String pilih;
            // tampilkan entrycounts == updateNum
            if (updateNum == entryCounts) {
                System.out.println("\nData yang ingin anda update adalah : ");
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
                System.out.println("dokter           : " + st.nextToken());
                System.out.println("kodedokter       : " + st.nextToken());
                System.out.println("nama             : " + st.nextToken());
                System.out.println("poli             : " + st.nextToken());
                System.out.println("noTelp           : " + st.nextToken());
                System.out.println("waktu            : 1. " + st.nextToken());
                System.out.println("                   2. " + st.nextToken());
                System.out.println("                   3. " + st.nextToken());
                System.out.println("                   4. " + st.nextToken());

                // update data
                // mengambil input dari admin
                String[] tempData = new String[8];

                st = new StringTokenizer(data, ",");
                String originalData = st.nextToken();
                // update tidak perlu yes no

//                String nama, noTelp, poli = "", kodedokter, pilih;
//                String jadwal[] = {"","","",""};
                System.out.print("Masukkan kode dokter, format=(YYYY) : ");
                tempData[0] = ambilkodedokter();
                System.out.print("Masukkan nama dokter : ");
                tempData[1] = inputDataNext.nextLine();
                System.out.print("Masukkan no telepon dokter : ");
                tempData[2] = inputDataNext.nextLine();
                System.out.println("\tJenis Poli     : ");
                System.out.println("\t\t1. Poli Umum");
                System.out.println("\t\t2. Poli Gigi");
                System.out.println("\t\t3. Poli Jiwa");
                System.out.println("\t\t4. Poli Penyakit Dalam");
                while (true) {
                    System.out.print("\t\tPilih menu : ");
                    pilih = inputData.next();
                    if (pilih.equals("1")) {
                        tempData[3] = "Poli Umum";
                        break;
                    } else if (pilih.equals("2")) {
                        tempData[3] = "Poli Gigi";
                        break;
                    } else if (pilih.equals("3")) {
                        tempData[3] = "Poli Jiwa";
                        break;
                    } else if (pilih.equals("4")) {
                        tempData[3] = "Poli Penyakit Dalam";
                        break;
                    } else {
                        System.out.println("Masukkan data yang benar!");
                    }
                }
                System.out.println("\tJadwal dokter : ");
                System.out.println("""
                                       \t\t1. 07.00 - 13.00
                                       \t\t2. 11.00 - 17.00
                                       \t\t3. 15.00 - 21.00""");
                while (true) {
                    System.out.print("\t\tPilih jadwal : ");
                    pilih = inputData.next();
                    if (pilih.equals("1")) {
                        tempData[4] = "07.00 - 08.30";
                        tempData[5] = "08.30 - 10.00";
                        tempData[6] = "10.00 - 11.30";
                        tempData[7] = "11.30 - 13.00";
                        break;
                    } else if (pilih.equals("2")) {
                        tempData[4] = "11.00 - 12.30";
                        tempData[5] = "12.30 - 14.00";
                        tempData[6] = "14.00 - 15.30";
                        tempData[7] = "15.30 - 17.00";
                        break;
                    } else if (pilih.equals("3")) {
                        tempData[4] = "15.00 - 16.30";
                        tempData[5] = "16.30 - 18.00";
                        tempData[6] = "18.00 - 19.30";
                        tempData[7] = "15.30 - 21.00";
                        break;
                    } else {
                        System.out.println("Masukkan data yang benar!");
                    }
                }

                // tampilkan jadwal baru ke layar
                // format data baru kedalam database
                String kodedokter = tempData[0];
                String nama = tempData[1];
                // String poli = tempData[2];
                // String noTelp = tempData[3];
                // String jadwal = tempData[4];

                // kita bikin primary key
                long nomorEntry = ambilEntryPerkodedokter(nama, kodedokter) + 1;

                String punulisTanpaSpasi = nama.replaceAll("\\s+", "");
                String primaryKey = punulisTanpaSpasi + "_" + kodedokter + "_" + nomorEntry;

                // tulis data ke database
                bufferedOutput.write(primaryKey + "," + tempData[0] + "," + tempData[1] + "," + tempData[2] + "," + "," + tempData[3] + "," + tempData[4] + "," + tempData[5] + "," + tempData[6] + "," + tempData[7]);

            } else {
                // copy data
                bufferedOutput.write(data);
            }
            bufferedOutput.newLine();

            data = bufferedInput.readLine();
        }

        // menulis data ke file
        bufferedOutput.flush();

        // delete original database
        database.delete();
        // rename file database menjadi database
        database.renameTo(database);

    }

    private static void deleteData() throws IOException {
        // kita ambil database original
        File tempDB = new File("tempDB.txt");
        FileReader fileInput = new FileReader(tempDB);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // kita buat database sementara
        File database = new File("database.txt");
        FileWriter fileOutput = new FileWriter(database);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
//        System.out.println("Liat Jadwal");
//        tampilkanData();

        // kita ambil user input untuk mendelete data
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\nMasukkan nomor jadwal yang akan dihapus: ");
        int deleteNum = terminalInput.nextInt();

        // looping untuk membaca tiap data baris dan skip data yang akan didelete
        boolean isFound = false;
        int entryCounts = 0;

        String data = bufferedInput.readLine();

        while (data != null) {
            entryCounts++;
            boolean isDelete = false;

            StringTokenizer st = new StringTokenizer(data, ",");

            // tampilkan data yang ingin di hapus
            if (deleteNum == entryCounts) {
                System.out.println("\nJadwal yang ingin anda hapus adalah : ");
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
                System.out.println("dokter       : " + st.nextToken());
                System.out.println("kodedokter           : " + st.nextToken());
                System.out.println("nama         : " + st.nextToken());
                System.out.println("poli        : " + st.nextToken());
                System.out.println("noTelp           : " + st.nextToken());
                System.out.println("waktu           : " + st.nextToken());

                isDelete = getYesorNo("Apakah anda yakin akan menghapus jadwal?");
                isFound = true;
            }

            if (isDelete) {
                //skip pindahkan data dari original ke sementara
                System.out.println("Jadwal berhasil dihapus");
            } else {
                // kita pindahkan data dari original ke sementara
                bufferedOutput.write(data);
                bufferedOutput.newLine();
            }
            data = bufferedInput.readLine();
        }

        if (!isFound) {
            System.err.println("Jadwal dokter tidak ditemukan");
        }

        // menulis data ke file
        bufferedOutput.flush();
        // delete original file
        database.delete();
        // rename file sementara ke database
        database.renameTo(database);

    }

    public static void tampilkanData() throws IOException {

        FileReader fileInput;
        BufferedReader bufferInput;

        try {
            fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("database tidak ditemukan");
            System.err.println("Silahkan tambah data terlebih dahulu");
            tambahData();
            return;
        }

        System.out.println("\n| No |\tkodedokter    |\tnama                |\tpoli               |\tnoTelp      |\tWaktu ");
        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");

        String data = bufferInput.readLine();
        int nomorData = 0;
        while (data != null) {
            nomorData++;

            StringTokenizer stringToken = new StringTokenizer(data, ",");

            stringToken.nextToken();
            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%4s  ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }

        System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
    }

    private static void cariData() throws IOException {

        // membaca database ada atau tidak
        try {
            File file = new File("database.txt");
        } catch (Exception e) {
            System.err.println("database Tidak ditemukan");
            System.err.println("Silahkan tambah data terlebih dahulu");
            tambahData();
            return;
        }

        // kita ambil keyword dari user
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Masukkan kata kunci untuk mencari jadwal : ");
        String cariString = terminalInput.nextLine();
        String[] keywords = cariString.split("\\s+");

        // kita cek keyword di database
        cekjadwalDidatabase(keywords, true);

    }

    private static void tambahData() throws IOException {
        FileWriter fileOutput = new FileWriter("database.txt", true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        // mengambil input dari admin
        //Scanner terminalInput = new Scanner(System.in);
        String nama, noTelp, poli = "", kodedokter, pilih;
        String jadwal[] = {"", "", "", ""};

        System.out.print("Masukkan nama dokter : ");
        nama = inputDataNext.nextLine();
        System.out.print("Masukkan noTelp dokter : ");
        noTelp = inputDataNext.nextLine();
        System.out.println("\tJenis Poli : ");
        System.out.println("\t\t1. Poli Umum");
        System.out.println("\t\t2. Poli Gigi");
        System.out.println("\t\t3. Poli Jiwa");
        System.out.println("\t\t4. Poli Penyakit Dalam");
        while (true) {
            System.out.print("\t\tPilih menu : ");
            pilih = inputData.next();
            if (pilih.equals("1")) {
                poli = "Poli Umum";
                break;
            } else if (pilih.equals("2")) {
                poli = "Poli Gigi";
                break;
            } else if (pilih.equals("3")) {
                poli = "Poli Jiwa";
                break;
            } else if (pilih.equals("4")) {
                poli = "Poli Penyakit Dalam";
                break;
            } else {
                System.out.println("Masukkan data yang benar!");
            }
        }
        System.out.println("\tJadwal dokter : ");
        System.out.println("""
                               \t\t1. 07.00 - 13.00
                               \t\t2. 11.00 - 17.00
                               \t\t3. 15.00 - 21.00""");
        while (true) {
            System.out.print("\t\tPilih jadwal : ");
            pilih = inputData.next();
            if (pilih.equals("1")) {
                jadwal[0] = "07.00 - 08.30";
                jadwal[1] = "08.30 - 10.00";
                jadwal[2] = "10.00 - 11.30";
                jadwal[3] = "11.30 - 13.00";
                break;
            } else if (pilih.equals("2")) {
                jadwal[0] = "11.00 - 12.30";
                jadwal[1] = "12.30 - 14.00";
                jadwal[2] = "14.00 - 15.30";
                jadwal[3] = "15.30 - 17.00";
                break;
            } else if (pilih.equals("3")) {
                jadwal[0] = "15.00 - 16.30";
                jadwal[1] = "16.30 - 18.00";
                jadwal[2] = "18.00 - 19.30";
                jadwal[3] = "15.30 - 21.00";
                break;
            } else {
                System.out.println("Masukkan data yang benar!");
            }
        }

        System.out.print("Masukkan kode dokter, format=(YYYY) : ");
        kodedokter = ambilkodedokter();

        // cek jadwal di database
        String[] keywords = {kodedokter + "," + nama + "," + poli + "," + noTelp + "," + jadwal[0] + "," + jadwal[1] + "," + jadwal[2] + "," + jadwal[3]};
        System.out.println(Arrays.toString(keywords));

        boolean isExist = cekjadwalDidatabase(keywords, false);

        // menulis jadwal di databse
        if (!isExist) {
//          Viona_2004_1,2004,Viona,Saraf,0852 5091 1597
            System.out.println(ambilEntryPerkodedokter(nama, kodedokter));
            long nomorEntry = ambilEntryPerkodedokter(nama, kodedokter) + 1;

            String punulisTanpaSpasi = nama.replaceAll("\\s+", "");
            String primaryKey = punulisTanpaSpasi + "_" + kodedokter + "_" + nomorEntry;
            System.out.println("\nJadwal yang akan anda masukkan adalah");
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀  ");
            System.out.println("primary key  : " + primaryKey);
            System.out.println("kodedokter : " + kodedokter);
            System.out.println("nama      : " + nama);
            System.out.println("noTelp        : " + noTelp);
            System.out.println("poli     : " + poli);
            System.out.println("waktu     : 1." + jadwal[0]);
            System.out.println("            2." + jadwal[1]);
            System.out.println("            3." + jadwal[2]);
            System.out.println("            4." + jadwal[3]);

            boolean isTambah = getYesorNo("Apakah akan ingin menambah jadwal tersebut?");

            if (isTambah) {
                bufferOutput.write(primaryKey + "," + kodedokter + "," + nama + "," + poli + "," + noTelp + "," + jadwal[0] + "," + jadwal[1] + "," + jadwal[2] + "," + jadwal[3]);
                bufferOutput.newLine();
                bufferOutput.flush();
            }

        } else {
            System.out.println("Jadwal yang anda akan masukkan sudah tersedia di database dengan data berikut : ");
            cekjadwalDidatabase(keywords, true);
        }

        bufferOutput.close();
    }

    private static long ambilEntryPerkodedokter(String nama, String kodedokter) throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        long entry = 0;
        String data = bufferInput.readLine();
        Scanner dataScanner;
        String primaryKey;

        while (data != null) {
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            primaryKey = dataScanner.next();
            dataScanner = new Scanner(primaryKey);
            dataScanner.useDelimiter("_");

            nama = nama.replaceAll("\\s+", "");
            System.out.println(dataScanner.next());

            if (nama.equalsIgnoreCase(dataScanner.next()) && kodedokter.equalsIgnoreCase(dataScanner.next())) {
                entry = dataScanner.nextInt();
            }

            data = bufferInput.readLine();
        }

        return entry;
    }

    private static boolean cekjadwalDidatabase(String[] keywords, boolean isDisplay) throws IOException {

        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist = false;
        int nomorData = 0;

        if (isDisplay) {
            System.out.println("\n| No |\tkodedokter    |\tnama                |\tpoli               |\tnoTelp      |\tWaktu ");
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }

        while (data != null) {

            // cek keywords didalam baris
            isExist = true;

            for (String keyword : keywords) {
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            // jika keywordsnya cocok maka tampilkan
            if (isExist) {
                if (isDisplay) {
                    nomorData++;
                    StringTokenizer stringToken = new StringTokenizer(data, ",");

                    stringToken.nextToken();
                    System.out.printf("| %2d ", nomorData);
                    System.out.printf("|\t%4s  ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.print("\n");
                } else {
                    break;
                }
            }

            data = bufferInput.readLine();
        }

        if (isDisplay) {
            System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        }

        return isExist;
    }

    private static String ambilkodedokter() throws IOException {
        boolean kodedokterValid = false;
        Scanner terminalInput = new Scanner(System.in);
        String kodedokterInput = terminalInput.nextLine();
        while (!kodedokterValid) {
            try {
                Year.parse(kodedokterInput);
                kodedokterValid = true;
            } catch (Exception e) {
                System.out.println("Format kode dokter yang anda masukkan salah, format=(YYYY)");
                System.out.print("Silahkan masukkan kode dokter lagi : ");
                kodedokterValid = false;
                kodedokterInput = terminalInput.nextLine();
            }
        }

        return kodedokterInput;
    }

    private static boolean getYesorNo(String message) {
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n" + message + " (y/n)? ");
        String pilihanUser = terminalInput.next();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n" + message + " (y/n)? ");
            pilihanUser = terminalInput.next();
        }

        return pilihanUser.equalsIgnoreCase("y");

    }
void konfirJanjiTemu() {
        // 1 tampil arr janji temu
        // 2 buat menu konfirmasi
        // 3 revalue / ubah var status janji temu di arr janji temu
        int indeks;
        System.out.println("=====================");
        System.out.println("  Daftar Janji Temu  ");
        System.out.println("=====================");
        for (int i = 0; i < arrJanjiTemu.size(); i++) {
            System.out.println(i + 1);
            System.out.println("ID pasien   : " + arrJanjiTemu.get(i).getIdPasien());
            System.out.println("ID dokter         : " + arrJanjiTemu.get(i).getIdDokter());
            System.out.println("Kode janji temu     : " + arrJanjiTemu.get(i).getKodeJanjiTemu());
            System.out.println("Waktu Temu          : " + arrJanjiTemu.get(i).getWaktuTemu());
            System.out.println("Status Temu          : " + arrJanjiTemu.get(i).getStatusJanjiTemu());
            System.out.println("==================================================================");
        }
            while (true) {
                try {
                        System.out.println("Pilih indeks Data : ");
                        indeks = Integer.valueOf(inputData.next());
                        if (indeks > 0 && indeks <= arrJanjiTemu.size()) {
                            break;
                        }
                } catch (NumberFormatException nfe) {
                    System.out.println("\tNomor telepon yang dimasukkan tidak sesuai!");
                }
           }
        
        Scanner input = new Scanner(System.in);
        String status = "Disetujui";
        
        System.out.print("Apakah janji temu disetujui? (y/n) ");
        String jawaban = input.nextLine();

        if (jawaban.equalsIgnoreCase("n")) {
           status = "Ditolak";
        }
        
        arrJanjiTemu.get(indeks).setStatusJanjiTemu(status);
        System.out.println("Status berhasil diperbarui");
      }
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("Tidak bisa clear screen");
        }
    }
}
