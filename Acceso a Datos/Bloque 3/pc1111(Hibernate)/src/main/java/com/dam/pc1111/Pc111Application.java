package com.dam.pc1111;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Pc111Application {

	public static void main(String[] args) {
		// SpringApplication.run(Pc111Application.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(Pc111Application.class, args);

		 // Pedimos a Spring los repositorios
        CategoriaRepository categorias = ctx.getBean(CategoriaRepository.class);
        ProductoRepository productos = ctx.getBean(ProductoRepository.class);
        ClienteRepository clientes = ctx.getBean(ClienteRepository.class);
		CompraRepository compras = ctx.getBean(CompraRepository.class);

        // ===== C - CREATE (insertar) =====
        Categoria perifericos = categorias.save(new Categoria("Periféricos"));
        Categoria monitores = categorias.save(new Categoria("Monitores"));

        Producto teclado = productos.save(new Producto("Teclado Cuevas", 25.90, 40, perifericos));
        Producto raton = productos.save(new Producto("Ratón", 12.50, 60, perifericos));
        productos.save(new Producto("Monitor 24 pulgadas", 129.00, 15, monitores));
        Producto alfombrilla = productos.save(new Producto("Alfombrilla", 5.00, 100, perifericos));


        Cliente cliente1 = clientes.save(new Cliente("Adrián"));
        clientes.save(new Cliente("Luis"));
		
		compras.save(new Compra(cliente1, teclado));
		compras.save(new Compra(cliente1, raton));

        // ===== R - READ (consultar) =====
        System.out.println("--- PRODUCTOS ---");
        for (Producto p : productos.findAll()) {
            System.out.println(p.getNombre() + " | " + p.getPrecio() + " | " + p.getCategoria().getNombre());
        }
        System.out.println("--- CLIENTES ---");
        for (Cliente c : clientes.findAll()) {
            System.out.println(c.getNombre());
        }

        // ===== U - UPDATE (modificar) =====
        raton.setPrecio(14.90);
        productos.save(raton);            // como ya tiene id, hace UPDATE

        // ===== D - DELETE (borrar) =====
        productos.deleteById(alfombrilla.getId());

        // ===== Comprobamos el resultado =====
        System.out.println("--- PRODUCTOS DESPUÉS DE MODIFICAR Y BORRAR ---");
        for (Producto p : productos.findAll()) {
            System.out.println(p.getNombre() + " | " + p.getPrecio());
        }
    }
	}


