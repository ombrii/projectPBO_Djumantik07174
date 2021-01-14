package Entity;
import java.util.Date;
public class UserEntity  extends Djumantik{ 
    protected Date tgl_sewa; 
    
    public UserEntity(String id,String nama,
    String alamat, String noIdentitas,String notelp,Date tgl_sewa,Date tgl_kembali){
        super(id,nama,alamat,noIdentitas,notelp); 
        this.tgl_sewa=tgl_sewa;
    }
    public UserEntity(){
    }    

   @Override 
     public String getId() {
        return id;
    }
 
    public void setid(String id) {
        this.id = id;
    }

    public Date getTgl_sewa() {
        return tgl_sewa;
    }

   
   
    
    public void setTgl_sewa(Date tgl_sewa) {
        this.tgl_sewa = tgl_sewa;
    }

}
