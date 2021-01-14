package Entity;
public class DaftarUserEntity {
   private UserEntity pelanggan; 
    private boolean isVerified;
    private int indexCamera; 
     public DaftarUserEntity(int indexCamera,
             UserEntity pelanggan, boolean isVerified) { 
         this.indexCamera = indexCamera;
        this.pelanggan = pelanggan;
        this.isVerified = isVerified;
    }
    public UserEntity getPelanggan() {
        return pelanggan;
    }
    public boolean isIsVerified() {
        return isVerified;
    }
    public int getIndexCamera() {
        return indexCamera;
    }
    public void setPelanggan(UserEntity pelanggan) {
        this.pelanggan = pelanggan;
    }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    public void setIndexCamera(int indexCamera) {
        this.indexCamera = indexCamera;
    }
}
