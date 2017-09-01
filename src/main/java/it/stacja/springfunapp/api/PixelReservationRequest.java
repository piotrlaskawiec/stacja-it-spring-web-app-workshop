package it.stacja.springfunapp.api;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PixelReservationRequest {

    @Min(0)
    @Max(99)
    private int row;

    @Min(0)
    @Max(99)
    private int column;
    
    private String color;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
