package View;
import Entity.DataEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class UserGUI {
    JFrame Pelanggan = new JFrame();
    JButton back,daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarcamera;
    JComboBox pilcamera = new JComboBox(DataEntity.merk);
    int cek = Allobjctrl.Pelanggan.cekDaftarPelanggan
        (Allobjctrl.Pelanggan.getData().getId());
    
    public UserGUI(){
        Pelanggan.setSize(720, 600);
        Pelanggan.setLayout(null);
        Pelanggan.getContentPane().setBackground(Color.YELLOW);
        
        datadiri = new JLabel("Data Pelanggan");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datadiri.setBounds(90, 30, 200, 30);
        Pelanggan.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Pelanggan.add(area);
        
        daftarcamera = new JLabel("HASIL");
        daftarcamera.setBounds(450, 30, 250, 30);
        daftarcamera.setFont(new Font("Times New Roman",Font.BOLD,30));
        Pelanggan.add(daftarcamera);
        pilcamera.setBounds(450, 90, 230, 30);
        Pelanggan.add(pilcamera);
        
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.YELLOW);
        Pelanggan.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.YELLOW);
        Pelanggan.add(back);
        
        Pelanggan.setVisible(true);
        Pelanggan.setLocationRelativeTo(null);
        Pelanggan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(cek==-1){ //cek data, apabila kita belum daftar praktkum
            JOptionPane.showMessageDialog(null, "Anda Belum Memasukan Hasil Survey", "Information", JOptionPane.INFORMATION_MESSAGE);        
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Memasukan Hasil Survey", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapelanggan());
        }
        daftarbtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            int indexcamera = pilcamera.getSelectedIndex();
            Allobjctrl.Pelanggan.Data
            (indexcamera,Allobjctrl.Pelanggan.getData(), false);
            area.setText(datapelanggan());
        }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Pelanggan.dispose();
                GUI men = new GUI(); //nama objek menu
            }
        });
    }
    
    String datapelanggan(){
        int cek = Allobjctrl.Pelanggan.cekDaftarPelanggan
        (Allobjctrl.Pelanggan.getData().getId());
        String cekverif; //untuk verivikasi data berdasarkan id
        if(Allobjctrl.Pelanggan.showDaftarPelanggan(cek).isIsVerified()==false){
            cekverif = "belum diverifikasi";
        }else{
            cekverif = "sudah diverifikasi";
        }
         String text = "Id = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getId()+"\n"
                +"Nama = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnama()+"\n"
                +"Alamat = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getalamat()+"\n"
                +"No Identitas = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnoIdentitas()+"\n"
                +"No Telp = "+Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getnotelp()+"\n"
                +"Tanggal survey = "+new SimpleDateFormat("dd-MM-yyyy").format(Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getPelanggan().getTgl_sewa())+"\n"
                +"Verifikasi = "+cekverif+"\n"
                +"Data = "+DataEntity.merk[Allobjctrl.Pelanggan.showDaftarPelanggan(cek).getIndexCamera()];
        return text;
    }
    }
    
