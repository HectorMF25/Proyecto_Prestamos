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
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class PrestamoModelo
{

private List<Prestamo> listPrestamo;


    public PrestamoModelo() {

    listPrestamo = new ArrayList<>();
    }

    public void asignarDatosPrestamo(String id, double m, double in, double p, Cliente c)
    {
        Prestamo prestamo = new Prestamo();
        prestamo.setId(id);
        prestamo.setMonto(m);
        prestamo.setInteres((in/100));
        prestamo.setPlazo(p);
        prestamo.setSaldo(m);
        prestamo.setCliente(c);
        double cuota = (prestamo.getSaldo() * prestamo.getInteres()) / (1 - (pow((1 + prestamo.getInteres()), -prestamo.getPlazo())));
        prestamo.setCuota(cuota);
        listPrestamo.add(prestamo);
    }

    public Prestamo devuelvePrestamo(String i)
    {
        int ind = Integer.parseInt(i);
        int flag = 0;
        for(Prestamo prestamo : listPrestamo)
        {
            if((ind-1) == listPrestamo.indexOf(prestamo))
            {
                flag =1;
                return prestamo;
            }
        }
        if(flag==0)
            return null;
        return null;
    }

    public void imprimePrestamo(String i)
    {
        int ind = Integer.parseInt(i);
        int flag = 0;
        for(Prestamo prestamo : listPrestamo)
        {
            if((ind-1) == listPrestamo.indexOf(prestamo))
            {
                flag =1;
                System.out.println("Numero en lista: "+(1+listPrestamo.indexOf(prestamo)));
                System.out.println(prestamo.toString());
            }
        }
        if(flag==0)
            System.out.println("Prestamo no encontrado");
    }

    public void listarPrestamos()
    {

        for(Prestamo prestamo : listPrestamo)
        {
            System.out.println(prestamo.toString());

        }
    }

    public List<Prestamo> devuelvePrestamos()
    {
        return listPrestamo;
    }

   public void listarPrestamosPorCliente(String id)
    {
        int flag = 0;
        int ID = Integer.parseInt(id);
        for (Prestamo prestamo : listPrestamo)
        {
            if(prestamo.getCliente().getCedula()==ID)
            {
                flag = 1;
                System.out.println("Numero en lista: "+(1+listPrestamo.indexOf(prestamo)));
                System.out.println(prestamo.toString());

            }
        }
        if(flag ==0)
            System.out.println("El usuario ingresado no posee ningun prestamo activo");
    }


    public void imprimeDatosPagoInteres(String index)
    {
        Iterator<Pago> p ;

        int i = Integer.parseInt(index);
        for(Prestamo prestamo : listPrestamo)
            if((i-1)==listPrestamo.indexOf(prestamo))
            {
                p = prestamo.getPagoList().iterator();
                while (p.hasNext())
                {

                        System.out.println("Este es el porcentanje del pago destinado a los intereses: "
                                + p.next().getMontoInteres());
                        break;

                }
            }

    }

    public void imprimeDatosPagoAmort(String index)
{
    Iterator<Pago> p ;

    int i = Integer.parseInt(index);
    for(Prestamo prestamo : listPrestamo)
        if((i-1)==listPrestamo.indexOf(prestamo))
        {
            p = prestamo.getPagoList().iterator();
            while (p.hasNext())
            {

                System.out.println("Este es el porcentaje destinado a la amortizacion: "
                                + Math.round(p.next().getAmortizacion()));
                break;
            }
        }

}
public void listaPagosdePrestamo()
{
    for (Prestamo prestamo : listPrestamo)
    {

        {
            System.out.println("Prestamo id: " + prestamo.getId());
            System.out.println("Id del cliente: " + prestamo.getCliente().getCedula());
            System.out.println("Nombre del cliente: " + prestamo.getCliente().getNombre());
        }
        for(Pago pago : prestamo.getPagoList())
        {
            System.out.println(pago.toString());
        }

    }
}

    public void generarRegistrodePagosXPrest()throws IOException
    {

        String n = "Lista de Pagos de un Prestamo";
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfWriter writer = new PdfWriter("Registro_de_pagos.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(50, 50, 50, 50);

        document.add(new Paragraph(n).setFont(font).setBold().setFontSize(20f));
        document.add(new Paragraph(""));
        document.add(new Paragraph(""));

        /*Table table = new Table(5);
        Cell c = new Cell();
        Color bkg = ColorConstants.LIGHT_GRAY;
        Color frg= ColorConstants.BLUE;*/


        for(Prestamo prestamo : listPrestamo)
        {
            {
                document.add(new AreaBreak());
                document.add(new Paragraph("Prestamo id: "+prestamo.getId()).setBold());
                document.add(new Paragraph("Cliente id: "+prestamo.getCliente().getCedula()).setBold());
                document.add(new Paragraph("Nombre del(a) cliente: "+prestamo.getCliente().getNombre()).setBold());
            }
            for(Pago pago : prestamo.getPagoList())
            {
                Table table = new Table(5);
                Cell c = new Cell();
                Color bkg = ColorConstants.LIGHT_GRAY;
                Color frg= ColorConstants.BLUE;
                c= new Cell(); c.add(new Paragraph("Fecha")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c= new Cell(); c.add(new Paragraph("Monto a pagar")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c= new Cell(); c.add(new Paragraph("Monto destinado al interes")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c= new Cell(); c.add(new Paragraph("Monto destinado a la Amortizacion")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);
                c= new Cell(); c.add(new Paragraph("Numero de cuota")).setBackgroundColor(bkg).setFontColor(frg);
                table.addHeaderCell(c);

                table.addHeaderCell(String.valueOf(pago.getFecha()));
                table.addHeaderCell(String.valueOf(Math.round(pago.getMontoPagar())));
                table.addHeaderCell(String.valueOf(pago.getMontoInteres()));
                table.addHeaderCell(String.valueOf(Math.round(pago.getAmortizacion())));
                table.addHeaderCell(String.valueOf(pago.getNumeroCuota()));


                document.add(table);

            }
        }
        document.close();
    }


}
