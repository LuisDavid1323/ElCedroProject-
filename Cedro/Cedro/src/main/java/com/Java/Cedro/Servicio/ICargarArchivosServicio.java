package com.Java.Cedro.Servicio;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ICargarArchivosServicio {
	
	public void save(MultipartFile file) throws Exception;
	public Resource load(String name) throws Exception;
	public void save(List<MultipartFile> files) throws Exception;
	public void saved(List<MultipartFile> files) throws Exception;
	public void guardar(List<MultipartFile> files) throws Exception;
	public void guardar1(List<MultipartFile> files) throws Exception;
	public void guardar2(List<MultipartFile> files) throws Exception;
	public Stream<Path> loadAll() throws Exception;
}
