package utils;

public class ElfArea {

    private int fromArea;
    private int toArea;

    public ElfArea(String area) {
        String[] splitArea = area.split("-");
        this.fromArea = Integer.valueOf(splitArea[0]);
        this.toArea = Integer.valueOf(splitArea[1]);
    }

    public boolean fullOverlap(ElfArea elfAreaToCheck) {
        if(this.fromArea <= elfAreaToCheck.fromArea && this.toArea >= elfAreaToCheck.toArea) {
            return true;
        }
        return false;
    }

    public boolean partialOverlap(ElfArea elfAreaToCheck) {
        if((this.fromArea <= elfAreaToCheck.toArea && this.toArea >= elfAreaToCheck.toArea)
                || (this.toArea >= elfAreaToCheck.fromArea && this.toArea <= elfAreaToCheck.toArea)) {
            return true;
        }
        return false;
    }
}
