import java.util.Scanner;

public class Main {
    public static void main( String[] args) {

        // Membuat array menu
        Menu[] menu = new Menu[]{
                new Menu("Odeng", 10000, "Makanan"),
                new Menu("Mandu", 13000, "Makanan"),
                new Menu("Kimchi", 13000, "Makanan"),
                new Menu("Kimbab", 18000, "Makanan"),
                new Menu("Hotteok", 16000, "Makanan"),
                new Menu("Japchae", 20000, "Makanan"),
                new Menu("Tteokpokki", 20000, "Makanan"),
                new Menu("Tteokkochi", 15000, "Makanan"),
                new Menu("Jjajangmyeon", 25000, "Makanan"),

                new Menu("Milsu", 10000, "Minuman"),
                new Menu("Yuja Tea", 15000, "Minuman"),
                new Menu("Omija Tea", 15000, "Minuman"),
                new Menu("Aloe Spark", 18000, "Minuman"),
                new Menu("Banana Milk", 14000, "Minuman"),
                new Menu("Honey Lemon", 22000, "Minuman"),
                new Menu("Goguma Latte", 25000, "Minuman"),
                new Menu("Creamy Manggo Bingsu", 32000, "Minuman"),
                new Menu("Salted Caramel Bingsu", 30000, "Minuman"),
        };

        User(menu);

    }

    public static void User(Menu[] menu) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI KOREAN fFOOD!");
        System.out.println("Silakan pilih user:");
        System.out.println("1. Pelanggan");
        System.out.println("2. Admin");
        System.out.println("Masukkan pilihan anda: ");

        int pilihanUser = scanner.nextInt();
        if (pilihanUser == 1) {
            System.out.println("Anda login sebagai Pelanggan");
            System.out.println("----------------------------");
            menuPelanggan(menu);
        } else if (pilihanUser == 2) {
            System.out.println("Anda login sebagai Admin");
            System.out.println("------------------------");
            manajemenMenu(menu);
        } else {
            System.out.println("Pilihan tidak valid");
            User(menu);
        }
    }

    private static void menuPelanggan(Menu[] menu) {

        // Menampilkan daftar menu
        Pelanggan.tampilDaftarMenu(menu);

        // Menerima pesanan dari pelanggan
        Pelanggan.terimaPesanan(menu);
    }

    public static void manajemenMenu(Menu[] menu) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manajemen Menu:");
        System.out.println("1. Tambah menu");
        System.out.println("2. Ubah harga");
        System.out.println("3. Hapus menu");
        System.out.println("4. Selesai");
        System.out.println("Masukkan pilihan anda:");

        int pilihanUser = scanner.nextInt();

        if (pilihanUser == 1) {
            KelolaAdmin.tambahMenu(menu);
        } else if (pilihanUser == 2) {
            KelolaAdmin.ubahHarga(menu);
        } else if (pilihanUser == 3) {
            KelolaAdmin.hapusMenu(menu);
        } else if (pilihanUser == 4) {
            User(menu);
        } else {
            System.out.println("Pilihan tidak valid");
            manajemenMenu(menu);
        }
    }
}
