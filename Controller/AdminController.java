package Controller;
import Entity.AdminEntity;
import Entity.DaftarUserEntity;
import Entity.UserEntity;
import java.util.Date;
import java.util.ArrayList;
public class AdminController implements ControllerInterface{
    int indexLogin = 0;
    public AdminController() {    
    }
    
    public void datapetugas(){
        String id[] = {"1","2","3"};
        String nama [] = {"bri","ojan","dandy"};
        String alamat [] = {"ngagel","manyar","sulawesi"};
        String noIdentitas [] = {"01","02","03"};
        String notelp [] = {"085733411381","02","03"};
              for(int i=0;i<id.length;i++){
                AllObjectModel.petugasModel.insertPetugas(new 
                AdminEntity(id[i],nama[i],alamat[i],
                noIdentitas[i],notelp[i]));
            }
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin =  AllObjectModel.petugasModel.cekData(id, nama);
    }
    
    public AdminEntity PetugasEntity() {
        return AllObjectModel.petugasModel.showDataPetugas(indexLogin);
    }
    
    public void updateIsVerified(int index,int indexCamera,UserEntity pelanggan ) {
        AllObjectModel.daftarPelangganmodel.updateIsVerified(index, new 
        DaftarUserEntity(indexCamera, pelanggan,true));
    }
    
    public ArrayList<DaftarUserEntity> cekDaftarPelangganModel() {
        return AllObjectModel.daftarPelangganmodel.getdaftarpelangganArrayList();
    }
}
