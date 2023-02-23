package com.Java.Cedro.servicioImpl;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import com.Java.Cedro.Servicio.ICargarArchivosServicio;
import com.Java.Cedro.modelo.Categoria_Insumo;
import com.Java.Cedro.modelo.Diseno;
import com.Java.Cedro.modelo.Insumo;
import com.Java.Cedro.modelo.Madera;
import com.Java.Cedro.modelo.Producto;
import com.Java.Cedro.modelo.Tela;
import com.Java.Cedro.repositorio.CInsumoRepositorio;
import com.Java.Cedro.repositorio.DisenoRepositorio;
import com.Java.Cedro.repositorio.InsumoRepositorio;
import com.Java.Cedro.repositorio.MaderaRepositorio;
import com.Java.Cedro.repositorio.ProductoRepositorio;
import com.Java.Cedro.repositorio.TelaRepositorio;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class CargarArchivosImpl implements ICargarArchivosServicio {

	private final Path rootFolder = Paths.get("uploads");

	// Repositorios
	@Autowired
	private MaderaRepositorio maderaRepositorio;

	@Autowired
	private ProductoRepositorio productosRepositorio;

	@Autowired
	private InsumoRepositorio insumoRepositorio;

	@Autowired
	private TelaRepositorio telaRepositorio;
	
	@Autowired
	private DisenoRepositorio disenoRepositorio;
	// Repositorios

	@Override
	public void save(MultipartFile file) throws Exception {

		Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename()));

	}

	@Override
	public Resource load(String name) throws Exception {
		return null;
	}

	// Woods
	@Override
	public void save(List<MultipartFile> files) throws Exception {

		for (MultipartFile file : files) {

			this.save(file);
			String nombreArchivo = "uploads/" + file.getOriginalFilename();

			try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

				XSSFWorkbook libro = new XSSFWorkbook(fil);

				XSSFSheet sheet = libro.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();

				Row row;

				row = rowIterator.next();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();

					Iterator<Cell> celIterator = row.cellIterator();
					Cell cell;

					while (celIterator.hasNext()) {
						cell = celIterator.next();

						System.out.println(cell.getStringCellValue());

						Madera madera = new Madera();

						madera.setNombre_madera(cell.getStringCellValue());
						cell = celIterator.next();
						madera.setPrecio(cell.getNumericCellValue());

						this.maderaRepositorio.save(madera);

					}
					System.out.println("");
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}

	}
	// Woods

	// Products
	@Override
	public void saved(List<MultipartFile> files) throws Exception {

		for (MultipartFile file : files) {

			this.save(file);
			String nombreArchivo = "uploads/" + file.getOriginalFilename();

			try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

				XSSFWorkbook libro = new XSSFWorkbook(fil);

				XSSFSheet sheet = libro.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();

				Row row;

				row = rowIterator.next();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();

					Iterator<Cell> celIterator = row.cellIterator();
					Cell cell;

					while (celIterator.hasNext()) {
						cell = celIterator.next();

						System.out.println(cell.getStringCellValue());

						Producto product = new Producto();

						product.setNombre_producto(cell.getStringCellValue());
						cell = celIterator.next();
						product.setPrecio(cell.getNumericCellValue());

						this.productosRepositorio.save(product);

					}
					System.out.println("");
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}

	}
	// Products

	// Insumos
	@Override
	public void guardar(List<MultipartFile> files) throws Exception {

		for (MultipartFile file : files) {

			this.save(file);
			String nombreArchivo = "uploads/" + file.getOriginalFilename();

			try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

				XSSFWorkbook libro = new XSSFWorkbook(fil);

				XSSFSheet sheet = libro.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();

				Row row;

				row = rowIterator.next();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();

					Iterator<Cell> celIterator = row.cellIterator();
					Cell cell;

					while (celIterator.hasNext()) {
						cell = celIterator.next();

						System.out.println(cell.getStringCellValue());

						Insumo in = new Insumo();

						in.setTel_distribuidor(cell.getStringCellValue());
						cell = celIterator.next();
						in.setDistribuidor(cell.getStringCellValue());
						cell = celIterator.next();
						in.setNombre(cell.getStringCellValue());
						cell = celIterator.next();
						in.setPrecio(cell.getStringCellValue());
						cell = celIterator.next();
						in.setStock((int) cell.getNumericCellValue());
						cell = celIterator.next();
						in.setUnidad_de_medida(cell.getStringCellValue());
						// cell = celIterator.next();
						// in.setId_categoria_insumo_fk((Categoria_Insumo)cell.getRichStringCellValue());

						this.insumoRepositorio.save(in);

					}
					System.out.println("");
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}

	}
	// Insumos

	// telas
	@Override
	public void guardar1(List<MultipartFile> files) throws Exception {

		for (MultipartFile file : files) {

			this.save(file);
			String nombreArchivo = "uploads/" + file.getOriginalFilename();

			try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

				XSSFWorkbook libro = new XSSFWorkbook(fil);

				XSSFSheet sheet = libro.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();

				Row row;

				row = rowIterator.next();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();

					Iterator<Cell> celIterator = row.cellIterator();
					Cell cell;

					while (celIterator.hasNext()) {
						cell = celIterator.next();

						System.out.println(cell.getStringCellValue());

						Tela t = new Tela();

						t.setNombre_tela(cell.getStringCellValue());
						cell = celIterator.next();
						t.setValor(cell.getNumericCellValue());

						this.telaRepositorio.save(t);

					}
					System.out.println("");
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}

	}
	// telas

	// Diseno
	@Override
	public void guardar2(List<MultipartFile> files) throws Exception {

		for (MultipartFile file : files) {

			this.save(file);
			String nombreArchivo = "uploads/" + file.getOriginalFilename();

			try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

				XSSFWorkbook libro = new XSSFWorkbook(fil);

				XSSFSheet sheet = libro.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();

				Row row;

				row = rowIterator.next();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();

					Iterator<Cell> celIterator = row.cellIterator();
					Cell cell;

					while (celIterator.hasNext()) {
						cell = celIterator.next();

						System.out.println(cell.getStringCellValue());

						Diseno d = new Diseno();
						
						cell = celIterator.next();
						d.setNombre_d(cell.getStringCellValue());
						cell = celIterator.next();
						

						this.disenoRepositorio.save(d);

					}
					System.out.println("");
				}

			} catch (Exception e) {
				e.getMessage();
			}
		}

	}
	// Diseno

	@Override
	public Stream<Path> loadAll() throws Exception {
		return null;
	}
}
