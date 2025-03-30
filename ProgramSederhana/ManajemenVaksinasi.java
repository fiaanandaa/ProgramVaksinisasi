/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramSederhana;

/**
 *
 * @author Fia Ananda Putri
 */
import java.util.Scanner;
import java.util.ArrayList;

class Vaksinasi {
    String nama;
    String jenisVaksin;

    public Vaksinasi(String nama, String jenisVaksin) {
        this.nama = nama;
        this.jenisVaksin = jenisVaksin;
    }

    public void display() {
        System.out.println("Nama: " + nama + ", Jenis Vaksin: " + jenisVaksin);
    }
}

public class ManajemenVaksinasi {
    static ArrayList<Vaksinasi> daftarVaksinasi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void tambahData() {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jenis Vaksin: ");
        String jenisVaksin = scanner.nextLine();
        daftarVaksinasi.add(new Vaksinasi(nama, jenisVaksin)); //method
        System.out.println("Data berhasil ditambahkan!\n");
    }

    public static void tampilkanData(int index) {
        if (index >= daftarVaksinasi.size()) {
            return;
        }
        daftarVaksinasi.get(index).display();
        tampilkanData(index + 1); // Rekursi untuk menampilkan data
    }

    public static void editData() {
        System.out.print("Masukkan Nama yang akan diedit: ");
        String nama = scanner.nextLine();
        for (Vaksinasi v : daftarVaksinasi) {
            if (v.nama.equalsIgnoreCase(nama)) {
                System.out.print("Masukkan Jenis Vaksin baru: ");
                v.jenisVaksin = scanner.nextLine();
                System.out.println("Data berhasil diperbarui!\n");
                return;
            }
        }
        System.out.println("Data tidak ditemukan!\n");
    }

    public static void hapusData() {
        System.out.print("Masukkan Nama yang akan dihapus: ");
        String nama = scanner.nextLine();
        for (Vaksinasi v : daftarVaksinasi) {
            if (v.nama.equalsIgnoreCase(nama)) {
                daftarVaksinasi.remove(v);
                System.out.println("Data berhasil dihapus!\n");
                return;
            }
        }
        System.out.println("Data tidak ditemukan!\n");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nManajemen Data Vaksinasi");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Edit Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    if (daftarVaksinasi.isEmpty()) {
                        System.out.println("Belum ada data vaksinasi.\n");
                    } else {
                        tampilkanData(0); // Memanggil rekursi untuk menampilkan data
                    }
                    break;
                case 3:
                    editData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    System.out.println("Terima kasih! Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!\n");
            }
        }
    }
}
