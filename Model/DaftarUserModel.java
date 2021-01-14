package Model; 
import Entity.DaftarUserEntity;
import Entity.DataEntity;
import Entity.AdminEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
public class DaftarUserModel implements ModeIinterfaces { 
    private ArrayList<DaftarUserEntity> daftarpelangganArrayList;
    public DaftarUserModel(){
    daftarpelangganArrayList = new ArrayList<DaftarUserEntity>();
        }
    public void insertDataPelanggan(DaftarUserEntity daftarpelanggan){
        daftarpelangganArrayList.add(daftarpelanggan);
    }
    public ArrayList<DaftarUserEntity> getdaftarpelangganArrayList(){
        return daftarpelangganArrayList;
    }
    @Override 
    public int cekData(String id, String nama){
        int loop = 0;
        if(daftarpelangganArrayList.size() ==0){
            loop = -1;//data kosong
        }else{
            for(int i = 0; i <daftarpelangganArrayList.size(); i++){
            if(daftarpelangganArrayList.get(i).getPelanggan().getId().equals(id)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
    public DaftarUserEntity showDaftarPelanggan(int index){
        return daftarpelangganArrayList.get(index); //menampilkan data pelanggan
    }
    public void hapusPelangganModel(int index) {
        daftarpelangganArrayList.remove(daftarpelangganArrayList.get(index)); //mengapus data pelanggan
    }
    public void updateIsVerified(int index,DaftarUserEntity daftarpelanggan){
    daftarpelangganArrayList.set(index, daftarpelanggan); 
    }
    public ArrayList <DaftarUserEntity> alldatapelanggan(){
        return  daftarpelangganArrayList;
    }
}
