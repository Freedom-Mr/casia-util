package casia.isiteam.api.toolutil.file;

import casia.isiteam.api.toolutil.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: CasiaFileUtil
 * Description: 文件工具类
 * <p>
 * Created by casia.wzy on 2020/4/21
 * Email: zhiyou_wang@foxmail.com
 */
public class CasiaFileUtil {
	private static Logger logger = LoggerFactory.getLogger(CasiaFileUtil.class);

	/**
	 * 判断文件是否存在
	 * @param path 路径
	 * @return
	 */
	public static boolean isExists(String path){
		try {
			return Files.exists( Paths.get(path) );
		}catch (Exception E){
			logger.error("isExists file fail, {}",E.getMessage());
			return false;
		}
	}

	/**
	 * 创建文件夹
	 * @param directoryPath 文件夹路径
	 * @return
	 */
	public synchronized static boolean createDirectory (String directoryPath){
		try {
			if( !isExists(directoryPath) ){
				Files.createDirectory( Paths.get( directoryPath ) );
			}
			return true;
		}catch (Exception E){
			logger.error("create directory fail, {}",E.getMessage());
			return false;
		}
	}

	/**
	 * 创建文件
	 * @param filePath 文件路径
	 * @return
	 */
	public synchronized static boolean createFile (String filePath){
		try {
			if( !isExists(filePath) ){
				Files.createFile( Paths.get(filePath) );
			}
			return true;
		}catch (Exception E){
			logger.error("create file fail, {}",E.getMessage());
			return false;
		}
	}

	/**
	 * 创建文件夹及其文件
	 * @param filePath 文件路径
	 * @return
	 */
	public synchronized static boolean createDirectoryFile (String filePath){
		try {
			if( !isExists(filePath) ){
				Path path = Paths.get(filePath);
				createDirectory( path.getParent().toString() );
				createFile( filePath );
			}
			return true;
		}catch (Exception E){
			logger.error("create file fail, {}",E.getMessage());
			return false;
		}
	}

	/**
	 * 拷贝文件
	 * @param startPath 起始文件路径
	 * @param endPath 结束文件路径
	 * @param isReplace 是否覆盖
	 * @return
	 */
	public synchronized static boolean copy (String startPath ,String endPath,boolean isReplace){
		try {
			if( isExists(startPath) ){
				if( isReplace ){
					Files.copy( Paths.get(startPath), Paths.get(endPath),StandardCopyOption.REPLACE_EXISTING);
				}else if( !isExists(endPath) ){
					Files.copy( Paths.get(startPath), Paths.get(endPath));
				}
				return true;
			}else{
				return false;
			}
		}catch (Exception E){
			logger.error("copy file fail, {}",E.getMessage());
			return false;
		}
	}

	/**
	 * 移动文件
	 * @param startPath 起始文件路径
	 * @param endPath 结束文件路径
	 * @param isReplace 是否覆盖
	 * @return
	 */
	public synchronized static boolean move (String startPath ,String endPath, boolean isReplace){
		try {
			if( isExists(startPath) ){
				if( isReplace ){
					Files.move( Paths.get(startPath), Paths.get(endPath) , StandardCopyOption.REPLACE_EXISTING );
				} else if( !isExists(endPath) ) {
					Files.move( Paths.get(startPath), Paths.get(endPath) );
				} else if( isExists(endPath) ){
					delete(startPath);
				}
				return true;
			}else{
				return false;
			}
		}catch (Exception E){
			logger.error("move file fail, {}",E.getMessage());
			return false;
		}
	}
	/**
	 * 删除文件
	 * @param filePaths 文件路径
	 * @return
	 */
	public synchronized static boolean delete (List<String> filePaths){
		filePaths.forEach(filePath->{
			try {
				if( isExists(filePath) ){
					Files.delete( Paths.get(filePath));
				}
			}catch (Exception E){
				logger.error("delete file fail, {}",E.getMessage());
				return;
			}
		});
		return true;
	}
	/**
	 * 删除文件
	 * @param filePath 文件路径
	 * @return
	 */
	public synchronized static boolean delete (String filePath){
		try {
			if( isExists(filePath) ){
				Files.delete( Paths.get(filePath));
			}
			return true;
		}catch (Exception E){
			logger.error("delete file fail, {}",E.getMessage());
			return false;
		}
	}

	/**
	 * 写入数据
	 * @param filePath 文件路径
	 * @param text 写入内容
	 * @param isAppend 是否追加写入
	 * @throws IOException
	 */
	public synchronized static boolean write(String filePath,String text, boolean isAppend){
		try {
			createDirectoryFile(filePath);
			Files.write(Paths.get(filePath), Validator.check(text) ? text.getBytes() : "".getBytes() , isAppend ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
		}catch (Exception E){
			logger.error("write file fail, {}",E.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 按行读取文件内容
	 * @param filePath	文件路径
	 * @param charset 编码格式，StandardCharsets.UTF_8 , 可默认为空
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<String> readAllLines(String filePath, Charset charset){
		try {
			List<String> lines =  Validator.check(charset) ? Files.readAllLines( Paths.get(filePath) , charset) : Files.readAllLines(Paths.get(filePath));
			return lines;
		}catch (Exception E){
			logger.error("readAllLines file fail, {}", E.getMessage());
			return new ArrayList<>();
		}
	}
	/**
	 * 按行读取文件内容
	 * @param filePath	文件路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<String> readAllLines(String filePath){
		return readAllLines(filePath,null);
	}
	/**
	 * 全部读取文件内容
	 * @param filePath	文件路径
	 * @param charset 编码格式，StandardCharsets.UTF_8 , 可默认为空
	 * @return
	 * @throws IOException
	 */
	public synchronized static String readAllBytes(String filePath, Charset charset){
		try {
			byte[] data = Files.readAllBytes(Paths.get(filePath));
			String content = Validator.check(charset) ? new String(data, charset) : new String(data);
			return content;
		}catch (Exception E){
			logger.error("readAllBytes file fail, {}",E.getMessage());
			return "";
		}
	}

	/**
	 * 全部读取文件内容
	 * @param filePath	文件路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static String readAllBytes(String filePath) {
		return readAllBytes(filePath,null);
	}

	/**
	 * 读取路径下所有文件名
	 * @param directoryPath	文件夹路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<String> readAllFileName(String directoryPath) {
		try {
			if( isExists(directoryPath) ){
				return Files.list(Paths.get(directoryPath)).filter(path -> Files.isRegularFile(path) ).map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
			}else{
				logger.warn("directory not exists ,path ={}",directoryPath);
				return new ArrayList<>();
			}
		} catch (Exception E){
			logger.error("read all fileName fail, {}",E.getMessage());
			return new ArrayList<>();
		}
	}
	/**
	 * 读取路径下所有文件路径
	 * @param directoryPath	文件夹路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<String> readAllFilePath(String directoryPath){
		try {
			if (isExists(directoryPath)) {
				return Files.list(Paths.get(directoryPath)).filter(path -> Files.isRegularFile(path)).map(Path::toString).collect(Collectors.toList());
			} else {
				logger.warn("directory not exists ,path ={}", directoryPath);
				return new ArrayList<>();
			}
		}catch (Exception E){
			logger.error("read all filePath fail, {}",E.getMessage());
			return new ArrayList<>();
		}
	}

	/**
	 * 读取路径下所有文件夹名
	 * @param directoryPath	文件夹路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<String> readAllDirectoryName(String directoryPath) {
		try {
			if( isExists(directoryPath) ){
				return Files.list(Paths.get(directoryPath)).filter(path -> Files.isDirectory(path) ).map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
			}else{
				logger.warn("directory not exists ,path ={}",directoryPath);
				return new ArrayList<>();
			}
		}catch (Exception E){
			logger.error("read all DirectoryName fail, {}",E.getMessage());
			return new ArrayList<>();
		}
	}
	/**
	 * 读取路径下所有文件夹路径
	 * @param directoryPath	文件夹路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<String> readAllDirectoryPath(String directoryPath) {
		try {
			if( isExists(directoryPath) ){
				return Files.list(Paths.get(directoryPath)).filter(path -> Files.isDirectory(path) ).map(Path::toString).collect(Collectors.toList());
			}else{
				logger.warn("directory not exists ,path ={}",directoryPath);
				return new ArrayList<>();
			}
		}catch (Exception E){
			logger.error("read all DirectoryPath fail, {}",E.getMessage());
			return new ArrayList<>();
		}
	}

	/**
	 * 读取路径下所有文件或文件夹PATH
	 * @param directoryPath	文件夹路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<Path> readAllPath(String directoryPath) {
		try {
			if( isExists(directoryPath) ){
				return Files.list(Paths.get(directoryPath)).collect(Collectors.toList());
			}else{
				logger.warn("directory not exists ,path ={}",directoryPath);
				return new ArrayList<>();
			}
		}catch (Exception E){
			logger.error("read all Path fail, {}",E.getMessage());
			return new ArrayList<>();
		}
	}
	/**
	 * 读取路径下所有文件或文件夹名称
	 * @param directoryPath	文件夹路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<String> readAllName(String directoryPath) {
		try {
			if( isExists(directoryPath) ){
				return Files.list(Paths.get(directoryPath)).map(Path::getFileName).map(Path::toString).collect(Collectors.toList());
			}else{
				logger.warn("directory not exists ,path ={}",directoryPath);
				return new ArrayList<>();
			}
		}catch (Exception E){
			logger.error("read all Path fail, {}",E.getMessage());
			return new ArrayList<>();
		}
	}
	/**
	 * 读取路径下所有文件或文件夹路径
	 * @param directoryPath	文件夹路径
	 * @return
	 * @throws IOException
	 */
	public synchronized static List<String> readAllDirectoryAndFilePath(String directoryPath) {
		try {
			if( isExists(directoryPath) ){
				return Files.list(Paths.get(directoryPath)).map(Path::toString).collect(Collectors.toList());
			}else{
				logger.warn("directory not exists ,path ={}",directoryPath);
				return new ArrayList<>();
			}
		}catch (Exception E){
			logger.error("read all Directory And FilePath fail, {}",E.getMessage());
			return new ArrayList<>();
		}
	}
}
