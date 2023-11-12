package utils;

public class ElfArea {

    private final int fromArea;
    private final int toArea;

    public ElfArea(String area) {
        String[] splitArea = area.split("-");
        this.fromArea = Integer.parseInt(splitArea[0]);
        this.toArea = Integer.parseInt(splitArea[1]);
    }

    public boolean fullOverlap(ElfArea elfAreaToCheck) {
        return this.fromArea <= elfAreaToCheck.fromArea && this.toArea >= elfAreaToCheck.toArea;
    }

    public boolean partialOverlap(ElfArea elfAreaToCheck) {
        return (this.fromArea <= elfAreaToCheck.toArea && this.toArea >= elfAreaToCheck.toArea)
                || (this.toArea >= elfAreaToCheck.fromArea && this.toArea <= elfAreaToCheck.toArea);
    }
}
