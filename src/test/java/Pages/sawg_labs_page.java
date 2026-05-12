package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class sawg_labs_page {
    WebDriver driver;

    // selectores
    By boton_agregar_carrito = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By boton_carrito = By.xpath("//a[@class='shopping_cart_link']");
    By boton_eliminar_carrito = By.id("remove-sauce-labs-backpack");
    By boton_siguiente = By.id("checkout");
    By nombre = By.id("first-name");
    By segundo_nombre = By.id("last-name");
    By codigo_postal = By.id("postal-code");
    By boton_siguiente_2 = By.id("continue");
    By mensaje_error = By.xpath("//h3[@data-test='error']");

    By filtros = By.cssSelector(".product_sort_container");
    By filtro_low_high = By.xpath("//option[@value='lohi']");
    By filtro_z_a = By.xpath("//option[@value='za']");
    By filtro_high_low = By.xpath("//option[@value='hilo']");

    By btn_hamburguesa = By.xpath("//button[@id='react-burger-menu-btn']");
    By btn_salir = By.id("logout_sidebar_link");

    public sawg_labs_page(WebDriver driver) {
        this.driver = driver;


    }


    public void agregar_carrito() {

        driver.findElement(boton_agregar_carrito).click();


    }


    public void eliminar_carrito() {
        driver.findElement(boton_carrito).click();

        driver.findElement(boton_eliminar_carrito).click();


    }
    /// ////////////////////////////////////////////////////////



    public void  no_agregar_elemento_informacion(String Nombre, String apellido, String cp) {
        driver.findElement(boton_agregar_carrito).click();

        driver.findElement(boton_carrito).click();

        driver.findElement(boton_siguiente).click();

        driver.findElement(nombre).sendKeys(Nombre);

        driver.findElement(segundo_nombre).sendKeys(apellido);

        driver.findElement(codigo_postal).sendKeys(cp);

        driver.findElement(boton_siguiente_2).click();


    }


/// //////////////////////////////////////////////////////////////////////////////////////////////////////

   public void orden_menor_mayor(){
       driver.findElement(filtros).click();
       driver.findElement(filtro_low_high).click();
   }

    public void orden_inverso(){
        driver.findElement(filtros).click();
        driver.findElement(filtro_z_a).click();
    }

    public void orden_mayor_menor(){
        driver.findElement(filtros).click();
        driver.findElement(filtro_high_low).click();
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void cerrar_Secion(){
     driver.findElement(btn_hamburguesa).click();
        try { Thread.sleep(500); } catch (Exception e) {}
     driver.findElement(btn_salir).click();

    }




/// //////////////////////////////////////////////////////////////////////////////////

public String obtenerFiltroSeleccionado(){

    Select filtro = new Select(
            driver.findElement(filtros)
    );

    return filtro.getFirstSelectedOption().getText();
}


    public String obtenerMensajeError() {

        return driver.findElement(mensaje_error).getText();
    }


    public String obtenerCantidadCarrito() {

        if (driver.findElements(
                By.className("shopping_cart_badge")
        ).size() > 0) {

            return driver.findElement(
                    By.className("shopping_cart_badge")
            ).getText();
        }

        return "0";
    }






}



