import java.util.ArrayList;
import java.util.Scanner;

public class Pelanggan {
    //Atribut nama, harga, dan kategori
    private String nama;
    private int harga;
    private String kategori;

    static Scanner scanner = new Scanner( System.in );


    public static void tampilDaftarMenu(Menu[] menu) {
        System.out.println( "***************************************************" );
        System.out.println( "SELAMAT DATANG DI KOREAN fFOOD" );
        System.out.println();
        System.out.println( "Daftar Menu Makanan:" );
        for (Menu m : menu) {
            if (m.getKategori().equals( "Makanan" )) {
                System.out.println( m.getNama() + "       Rp " + m.getHarga() + " " );
            }
        }

        System.out.println();
        System.out.println( "Daftar Menu Minuman:" );
        for (Menu m : menu) {
            if (m.getKategori().equals( "Minuman" )) {
                System.out.println( m.getNama() + "       Rp " + m.getHarga() + " " );
            }
        }
    }

    public static void terimaPesanan(Menu[] menu) {
        int totalHargaPesanan = 0;
        int totalPesanan = 0;

        System.out.println();
        System.out.println( "Contoh format input: Kimchi = 2" );
        System.out.println( "Ketik \"Selesai\" jika sudah selesai memesan." );
        System.out.println( "Silakan masukkan menu yang ingin dipesan:" );


        ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
        while (true) {
            String pesananInput = scanner.nextLine().trim();

            if (pesananInput.equalsIgnoreCase( "Selesai" )) {
                if (totalPesanan < 1) {
                    System.out.println( "Anda belum memesan apapun. Masukkan menu terlebih dahulu'" );
                    continue;
                } else {
                    break; // Keluar dari loop jika pengguna mengetik 'selesai'
                }
            }

            // Memisahkan nama menu dan jumlah dengan menggunakan "=" sebagai pemisah
            String[] pesananSplit = pesananInput.split( "=" );

            if (pesananSplit.length != 2) {
                System.out.println( "Format pesanan tidak valid." );
                continue;
            }

            String namaMenu = pesananSplit[0].trim();
            int jumlah = Integer.parseInt( pesananSplit[1].trim() );

            // Cari menu yang sesuai dengan nama menu yang diinputkan
            boolean found = false;
            for (Menu value : menu) {
                if (value.getNama().equalsIgnoreCase( namaMenu )) {
                    // masukkan pesanan ke array class pesanan
                    daftarPesanan.add( new Pesanan( namaMenu, jumlah, value.getHarga() ) );
                    found = true;
                    totalPesanan++;
                    break;
                }
            }

            if (!found) {
                System.out.println( "Menu '" + namaMenu + "' tidak ditemukan." );
            }
        }


        // Mengitung Total Harga Pesanan
        for (Pesanan m : daftarPesanan) {
            if (m != null) {
                totalHargaPesanan += m.getTotalHarga() * m.getTotalPesanan();
            }
        }
        System.out.println( "Total Harga Pesanan: " + totalHargaPesanan );

        // Penawaran B1G1 untuk harga pesanan di atas 50.000
        if (totalHargaPesanan > 50000) {
            System.out.println( "Selamat! Anda mendapatkan penawaran khusus B1G1 Minuman." );
            System.out.println( "Silakan Pilih menu di bawah ini" );
            // Tampilkan menu kategori minuman
            System.out.println( "Daftar Menu Minuman:" );
            for (Menu m : menu) {
                if (m.getKategori().equals( "Minuman" ) && (m.getNama().equals( "Omija Tea" ) || m.getNama().equals( "Yuja Tea" ))) {
                    System.out.println( m.getNama() + " - Rp " + m.getHarga() );
                }
            }
            int[] minumanList = new int[1];
            int y = 0;
            System.out.println( "Masukkan menu B1G1 :" );
            while (y < minumanList.length) {
                String InputDrink = scanner.nextLine();
                boolean minumanditemukan = false;
                if (InputDrink.equalsIgnoreCase( "selesai" )) {
                    break; // Keluar dari loop jika pengguna mengetik 'selesai'
                }
                for (Menu value : menu) {
                    if (value.getNama().equalsIgnoreCase( InputDrink )) {
                        // masukkan pesanan ke array class pesanan
                        daftarPesanan.add( new Pesanan( InputDrink, 1, 0 ) );

                        minumanditemukan = true;
                        y++;
                        break;
                    }
                }
                if (!minumanditemukan) {
                    System.out.println( "Menu '" + InputDrink + "' tidak ditemukan." );
                }
            }
        }

        scanner.close(); // Ingat untuk menutup scanner setelah selesai menggunakannya.
        tampilkanStruk( daftarPesanan.toArray( new Pesanan[0]));
    }

    public static void tampilkanStruk(Pesanan[] pesanan) {
        //Menyimpan variabel total, pajak, hargaA akhir, pelayanan, dan total pembayaran
        int total = 0;
        int Pajak = 0;
        int hargaAkhir = 0;
        int Pelayanan = 20000;
        int totalPembayaran = 0;


        // Mencetak struk ke layar
        System.out.println( );
        System.out.println( "---------------------------------------" );
        System.out.println( "Struk Pesanan" );
        System.out.println( "---------------------------------------" );
        System.out.println( "Item\t\tJumlah\t\tHarga\t\tTotal Harga" );

        for (Pesanan m : pesanan) {
            if (m != null) {
                System.out.println( m.getNamaPesanan() + "\t\t" + m.getTotalPesanan() + "\t\t" + m.getTotalHarga() + "\t\t" + m.getTotalHarga() * m.getTotalPesanan() );
                total += m.getTotalHarga() * m.getTotalPesanan();
            }
        }
        System.out.println( "------------------------" );
        System.out.println("Total Harga              : Rp " + total);
        if (total > 100000) {
            System.out.println("Diskon (10%)             : Rp " + (total * 0.1));
            total -= (total * 0.1);
            System.out.println("Harga Setelah Diskon     : Rp  " + total);
        }
        System.out.println("Pajak (10%)              : Rp " + (total * 0.1));
        Pajak = total * 10 / 100;
        hargaAkhir = total + Pajak;
        System.out.println("Total Harga Setelah Pajak: Rp " + hargaAkhir);
        System.out.println("Pelayanan                : Rp " + Pelayanan);
        totalPembayaran = hargaAkhir + Pelayanan;
        System.out.println("Total Pembayaran         : Rp " + totalPembayaran);
        System.out.println( );
        System.out.println("Terima kasih. Sampai jumpa lagi!");
        System.out.println( "***************************************************" );
    }
}
