package Model;
import Entity.DataEntity;
import Entity.UserEntity;
import Model.DaftarUserModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class UserModel implements ModeIinterfaces { 
    private ArrayList<UserEntity> pelangganEntityArrayList;
     
     public UserModel(){
        pelangganEntityArrayList = new ArrayList<UserEntity>();
    }
public void insert(UserEntity pelangganEntity){ //menambah data pelanggan
    pelangganEntityArrayList.add(pelangganEntity);  
}
public void hapusPelangganModel(int index) { //hapus data pelanggan 
        pelangganEntityArrayList.remove(pelangganEntityArrayList.get(index));
    }
 public int size() {
        return pelangganEntityArrayList.size();
    }
 @Override
    public int cekData(String id, String nama){
        int loop = 0;
        while (!pelangganEntityArrayList.get(loop).getId().equals(id) && 
                !pelangganEntityArrayList.get(loop).getnama().equals(nama)){
            loop++;
        }
        return loop;
    }
    public UserEntity getpelangganEntityArrayList(int index){ //
        return pelangganEntityArrayList.get(index);
    }
}
