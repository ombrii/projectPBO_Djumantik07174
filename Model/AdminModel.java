package Model;
import Entity.AdminEntity;
import java.util.ArrayList;
public class AdminModel implements ModeIinterfaces{ 
    private  ArrayList <AdminEntity> PetugasEntityArrayList;   
    public AdminModel(){
    PetugasEntityArrayList = new ArrayList<AdminEntity>();
    }
    public void insertPetugas(AdminEntity petugas){
        PetugasEntityArrayList.add(petugas);
    }
     @Override   
    public int cekData(String id, String nama){
        int loop = 0;
        for(AdminEntity petugasEntity : PetugasEntityArrayList){
            if(petugasEntity.getId().equals(id) && petugasEntity.getnama().equals(nama)){
            break;
            }else{
                loop++;
            }
        }
        return loop;
   }
    public AdminEntity showDataPetugas(int index){
        return PetugasEntityArrayList.get(index);
    }
}
