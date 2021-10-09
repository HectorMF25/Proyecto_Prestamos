package Modelo;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteModelo
{

private List<Cliente> listaCli;
    public ClienteModelo() {

        listaCli = new ArrayList<>();
    }

    public void asignaDatosCliente(int id, String n, String p, String c, String d)
    {
        Cliente cli = new Cliente();
        cli.setCedula(id);
        cli.setNombre(n);
        cli.setProvincia(p);
        cli.setCanton(c);
        cli.setDistrito(d);
        listaCli.add(cli);
    }

    public void listarClientes()
    {

        for(Cliente cli : listaCli)
        {

            System.out.println(cli.toString());

        }
    }

    public boolean buscarClienteBool(String id)
    {
        int flag = 0;
        int ID = Integer.parseInt(id);
        for(Cliente cli : listaCli)
        {
            if (ID == cli.getCedula())
            {
                return true;
            }
        }
        if(flag==0)
            return false;
        return false;
    }

    public Cliente buscarClienteID(String id)
    {
        int flag = 0;
        int ID = Integer.parseInt(id);
        for(Cliente cli : listaCli)
        {
            if (ID == cli.getCedula())
            {
                flag = 1;
                return cli;
            }
        }
        if(flag==0)
            return null;

        return null;
    }

    public void generarregistroClientes()throws IOException
    {

        String n = "Lista de Clientes";
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfWriter writer = new PdfWriter("Registro_de_Clientes.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());//pdf, PageSize.A4.rotate());
        document.setMargins(50, 50, 50, 50);

        document.add(new Paragraph(""));
        document.add(new Paragraph(n).setFont(font).setBold().setFontSize(20f));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));

        Table table = new Table(5);
        Cell c = new Cell();
        Color bkg = ColorConstants.LIGHT_GRAY;
        Color frg= ColorConstants.BLUE;

        c= new Cell(); c.add(new Paragraph("Nombre")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Cedula")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Provincia")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Canton")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Distrito")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);

        for(Cliente cli : listaCli)
        {
            {
                //System.out.println(cli.toString());

                table.addHeaderCell(cli.getNombre()+"");
                table.addHeaderCell(cli.getCedula()+"");
                table.addHeaderCell(cli.getProvincia()+"");
                table.addHeaderCell(cli.getCanton()+"");
                table.addHeaderCell(cli.getDistrito()+"");

            }
        }
        document.add(table);
        document.close();
    }
}
