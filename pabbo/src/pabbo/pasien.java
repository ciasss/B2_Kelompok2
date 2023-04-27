
package pabbo;

import java.io.*;
import java.util.*;
import static pabbo.Main.alamat;
import static pabbo.Main.inputData;
import static pabbo.Main.inputDataNext;
import static pabbo.Main.inputInt;
import static pabbo.Main.konfirPass;
import static pabbo.Main.nama;
import static pabbo.Main.newAkun;
import static pabbo.Main.noTelp;
import static pabbo.Main.pass;
import static pabbo.Main.ttl;
import static pabbo.Main.username;
import static pabbo.Main.arrJanjiTemu;
import static pabbo.Main.arrPasien;
import static pabbo.Main.arrDokter;


public class pasien extends user implements menuUser{

    private String nama;
    private String ttl;
    private String noTelp;
    private String alamat;

    public pasien(String username, String pass, String nama, String ttl, String noTelp, String alamat) {
        super(username, pass);
        this.nama = nama;
        this.ttl = ttl;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    
    @Override
    int login()throws IOException{
        System.out.println("SELAMAT DATANG " + this.nama + "!");
        return menu();
    }
    
    public void setTTL(String ttl) throws InvalidTTLException
	{
		if(ttl.matches("(\\d.*)/(\\d.*)/(\\d.*)"))
		{
			this.ttl = ttl;
		}
		else
		{
			throw new InvalidTTLException(ttl);
		}
	}
	
	public String getTTL()
	{
		return this.ttl;
	}

    @Override
    public int menu() throws IOException{     
        while (true) { 
            // clearScreen();
            
            System.out.println("[1] Data Profil");
            System.out.println("[2] Lihat Jadwal Dokter");
            System.out.println("[3] Buat Janji Temu");
            System.out.println("[4] Status Janji Temu");
            System.out.println("[5] Keluar program");
            System.out.println("===========================================");
            LOOP:
            while (true) {
                System.out.print("\tMasukkan Pilihan: ");
                String pilihMenu = inputData.next();
                switch (pilihMenu) {
                    case "1" -> {// UPDATE
                        System.out.println("Ubah data profil");
                        this.dataProfil();
                        break LOOP;
                    }

                    case "2" -> {
                        System.out.println("Jadwal dokter");
                        this.tampilJadwalDokter();
                        break LOOP;
                    }

                    case "3" -> {// READ
                        System.out.println("Buat janji temu");
                        if (!arrDokter.isEmpty()) {
                            this.buatJanjiTemu();
                        } else {
                            System.out.println("Belum ada dokter");
                        }
                        break LOOP;
                    }

                    case "4" -> {
                        if (!arrJanjiTemu.isEmpty()) {
                            System.out.println("Update");
                            // tampilkan data janji temu berdasarkan username
                            this.statusJanjiTemu();
                        } else {
                            System.out.println("Belum ada janji temu");
                        }
                        break LOOP;
                    }

                    case "5" -> {
                        System.out.println("Keluar");
                        return 0;
                    }

                    default ->
                            System.err.println("Pilih menu 1-5!");
                }

            }
        }
    }

    boolean verifikasiData() {
        String dataVerifikasi;
        System.out.println("Masukkan password : ");
        dataVerifikasi = inputData.next();
        return dataVerifikasi.equals(super.getPass());
    }

    void dataProfil() {
        String pilihMenu;
        System.out.println("===========================================");
        System.out.println("Data profil anda : ");
        System.out.println("Nama       : " + this.nama);
        System.out.println("TTL        : " + this.ttl);
        System.out.println("No Telpon  : " + this.noTelp);
        System.out.println("Alamat     : " + this.alamat);
        System.out.println("===========================================");

        System.out.println("1. Ubah data");
        System.out.println("2. Ubah data spesifik");
        System.out.println("3. Ubah username");
        System.out.println("4. Ubah password");
        System.out.println("5. Kembali");
        System.out.println("===========================================");
        while (true) {
            System.out.print("\tMasukkan Pilihan: ");
            pilihMenu = inputData.next();
            if (pilihMenu.equals("1")) {
                this.ubahData();
                break;
            } else if (pilihMenu.equals("2")) {
                this.UbahSpesifikData();
                break;
            } else if (pilihMenu.equals("3")) {
                this.ubahUsername();
                break;
            } else if (pilihMenu.equals("4")) {
                this.ubahPassword();
                break;
            } else if (pilihMenu.equals("5")) {
                return;
            } else {
                System.out.println("Masukkan data yang benar!");
            }
        }
        //System.out.println("data berhasil diubah");
    }

    void ubahData() {
        System.out.println("Ubah data menjadi :");
        while (true) {
            System.out.print("       Nama Lengkap : ");
            nama = inputDataNext.nextLine();
            do {
                try {
                    System.out.print("       TTL          : ");
                    this.setTTL(inputData.next());
                } catch (InvalidTTLException invalidTTL) {
                    System.out.print(invalidTTL.toString());
                    System.out.print("Masukkan TTL dengan format \"DD/MM/YYYY\".\n");
                }
            } while (this.getTTL() == null);

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
        }
    }

    void UbahSpesifikData() {
        System.out.println("1. Nama");
        System.out.println("2. TTL");
        System.out.println("3. No Telpon");
        System.out.println("4. Alamat");
        while (true) {
            System.out.print("\tMasukkan Pilihan: ");
            String pilihMenu = inputData.next();
            if (pilihMenu.equals("1")) {
                this.nama = inputData.next();
                break;
            } else if (pilihMenu.equals("2")) {
                do {
                    try {
                        System.out.print("       TTL          : ");
                        this.setTTL(inputData.next());
                    } catch (InvalidTTLException invalidTTL) {
                        System.out.print(invalidTTL.toString());
                        System.out.print("Masukkan TTL dengan format \"DD/MM/YYYY\".\n");
                    }
                } while (this.getTTL() == null);
                break;
            } else if (pilihMenu.equals("3")) {
                this.noTelp = inputData.next();
                break;
            } else if (pilihMenu.equals("4")) {
                this.alamat = inputData.next();
                break;
            } else {
                System.out.println("Masukkan data yang benar");
            }
        }
    }

    void ubahUsername() {
        String pilihMenu;
        int i;
        System.out.println("Username anda : " + super.getUsername());
        System.out.println("Ubah menjadi");
        while (true) {
            System.out.print("Username baru : ");
            String username = inputData.next();
            if (username.equals(super.getUsername())) {
                System.out.println("username berhasil diubah");
                return;
            } else if (username.equals("admin")) {
                System.out.println("Username telah digunakan");
                System.out.println("1. Masukkan username baru");
                System.out.println("2. Batal mengubah username");
                while (true) {
                    System.out.print("\tMasukkan Pilihan : ");
                    pilihMenu = inputData.next();
                    if (pilihMenu.equals("1")) {
                        break;
                    } else if (pilihMenu.equals("2")) {
                        return;
                    } else {
                        System.out.println("Masukkan data yang benar!");
                    }
                }
            } else {
                for (i = 0; i < arrPasien.size(); i++) {
                    if (arrPasien.get(i).getUsername().equals(username)) {
                        System.out.println("Username telah digunakan");
                        System.out.println("1. Masukkan username baru");
                        System.out.println("2. Batal mengubah username");
                        while (true) {
                            System.out.print("\tMasukkan Pilihan : ");
                            pilihMenu = inputData.next();
                            if (pilihMenu.equals("1")) {
                                break;
                            } else if (pilihMenu.equals("2")) {
                                return;
                            } else {
                                System.out.println("Masukkan data yang benar!");
                            }
                        }
                        break;
                    }
                }
                if (i == arrPasien.size()) {

                    super.setUsername(username);
                    System.out.println("Username berhasil diubah");
                    return;
                }
            }
        }

    }

    void ubahPassword() {
        String passwordBaru, passwordLama, pilihMenu;
        System.out.print("Password baru : ");
        passwordBaru = inputData.next();
        while (true) {
            System.out.println("Konfirmasi password sebelumnya");
            System.out.print("Password lama : ");
            passwordLama = inputData.next();
            if (passwordLama.equals(super.getPass())) {
                super.setPass(passwordBaru);
                System.out.println("Password berhasil diubah");
                return;
            }
            System.out.println("password salah");
            System.out.println("1. Masukkan password lagi");
            System.out.println("2. Batal mengubah password");
            while (true) {
                System.out.print("\tMasukkan Pilihan: ");
                pilihMenu = inputData.next();
                if (pilihMenu.equals("1")) {
                    break;
                } else if (pilihMenu.equals("2")) {
                    return;
                } else {
                    System.out.println("Masukkan data yang benar!");
                }
            }
        }
    }

    void tampilJadwalDokter() throws IOException {
        System.out.println("Tampil jadwal dokter");
        admin.tampilkanData();
    }

    void buatJanjiTemu() throws IOException {
        String username, kodeDokter, waktuTemu, statusJanjiTemu;
        System.out.println("=====================");
        System.out.println("    Jadwal Dokter    ");
        System.out.println("=====================");
        admin.tampilkanData();
        System.out.println("=====================");
        System.out.println("   Buat Janji Temu   ");
        System.out.println("=====================");
        System.out.print("Username : ");
        username = inputData.next();
        if(!username.matches("[a-zA-Z_ ]+")){
            System.out.println("===============");
            System.out.println("Masukkan Huruf!");
            System.out.println("===============");
        }
        System.out.print("Kode dokter : ");
        kodeDokter = inputData.next();
        if(!kodeDokter.matches("[0-9]+")){
            System.out.println("===============");
            System.out.println("Masukkan Angka!");
            System.out.println("===============");
        }
        System.out.println("=================");
        System.out.println("  Daftar Dokter  ");
        System.out.println("=================");
        FileReader fileInput;
        BufferedReader bufferInput = null;
        
        String database = "C:\\Users\\cicia\\OneDrive\\Dokumen\\NetBeansProjects\\pabbo\\database.txt";
        String line = "";
        String separator = ",";
        int nomorData = 0;
        bufferInput = new BufferedReader(new FileReader(database));
        while((line = bufferInput.readLine()) != null){
            nomorData++;
            String[] parsingFile = line.split(separator);
            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%4s  ", parsingFile[2]);
        }
        waktuTemu = "";
        
        System.out.print("Status temu : ");
        statusJanjiTemu = "Belum disetujui";
        
        arrJanjiTemu.add(new janjiTemu(super.getUsername(), kodeDokter, waktuTemu, statusJanjiTemu));
        System.out.println("Data berhasil ditambahkan!");
    }

    void statusJanjiTemu() {
        System.out.println("Status janji temu");
        // 1 menampilkan data janji temu yg telah dibuat
        int data = 0;
        for(int i = 0; i < arrJanjiTemu.size(); i++){
            if(arrJanjiTemu.get(i).idPasien.equals(this.getUsername())){
                data++;
            }
        }
        if(data == 0){
            System.out.println("===================");
            System.out.println("Daftar Masih Kosong");
            System.out.println("===================");
        }else{
            System.out.println("=====================");
            System.out.println("  Daftar Janji Temu  ");
            System.out.println("=====================");
            for (int i = 0; i < arrJanjiTemu.size(); i++) {
                System.out.println("Username   : " + arrJanjiTemu.get(i).idPasien);
                System.out.println("ID dokter         : " + arrJanjiTemu.get(i).idDokter);
                System.out.println("Waktu Temu          : " + arrJanjiTemu.get(i).getWaktuTemu());
                System.out.println("Status Temu          : " + arrJanjiTemu.get(i).getStatusJanjiTemu());
                System.out.println("==================================================================");
            }
        }
    }
}