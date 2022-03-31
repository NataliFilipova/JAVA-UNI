package Classes;

public class Material {
    String materialName;
    boolean isFragile;

    public Material(String materialName, boolean isFragile) {
        this.materialName = materialName;
        this.isFragile = isFragile;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }
}
