package Controller;
import Entity.DaftarUserEntity;
import Entity.UserEntity;
import Model.UserModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class UserController implements ControllerInterface{
    int indexLogin = 0;
    
    public UserController() {
    }
    
    public UserEntity getData() {
        return AllObjectModel.pelangganModel.getpelangganEntityArrayList(indexLogin);
    }
    
    public void Data(int indexCamera,  UserEntity pelanggan,
            boolean isVerified) {
        AllObjectModel.daftarPelangganmodel.insertDataPelanggan(new 
        DaftarUserEntity (indexCamera,pelanggan, isVerified));
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin = AllObjectModel.pelangganModel.cekData(id, nama);
    }
    
    public void insert(String id,String nama,
    String alamat, String noIdentitas,String notelp,Date tgl_sewa) {
        UserEntity pelangganModel = new UserEntity();
        pelangganModel.setid(id);
        pelangganModel.setnama(nama);
        pelangganModel.setalamat(alamat);
        pelangganModel.setnoIdentitas(noIdentitas);
        pelangganModel.setnotelp(notelp);
        pelangganModel.setTgl_sewa(tgl_sewa);
        AllObjectModel.pelangganModel.insert(pelangganModel);
    }

    public int cekDaftarPelanggan(String id) {
        int cek = AllObjectModel.daftarPelangganmodel.cekData(id, null);
        return cek;
    }
    
    public DaftarUserEntity showDaftarPelanggan(int index) {
        return AllObjectModel.daftarPelangganmodel.showDaftarPelanggan(index);
    }
    public void deleteDataPelanggan(int index) {
        AllObjectModel.daftarPelangganmodel.hapusPelangganModel(index);
    }
    public ArrayList<DaftarUserEntity> cekDaftarPelangganModel() {
        return AllObjectModel.daftarPelangganmodel.getdaftarpelangganArrayList();
    }
    public DefaultTableModel daftarpel(){
        DefaultTableModel dtmdaftarpel = new DefaultTableModel();
        Object[] kolom ={"Id","Nama","Alamat","No Identitas","No Telp","Tgl Survey","Data","Verified"};
        dtmdaftarpel.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftarPelangganmodel.alldatapelanggan().size();
        String verif = null;
        for(int i=0;i<size;i++){
            if(AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).isIsVerified()==false){
                verif = "no";
            }else{
                verif = "yes";
            }
            Object [] data = new Object[9];
            data[0] = AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getId();
            data[1] = AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getnama();
            data[2] = AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getalamat();
            data[3] = AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getnoIdentitas();
            data[4] = AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getnotelp();
            data[5] = AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getPelanggan().getTgl_sewa();
            data[6] = AllObjectModel.daftarPelangganmodel.alldatapelanggan().get(i).getIndexCamera();
            data[7] = verif;
            dtmdaftarpel.addRow(data);
    }
        return dtmdaftarpel;
    }
}
