package com.atecher.blog.web.util;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.util.Locale;

public class ApplicationMonitor {
	private long usedMemory;
	private long maxMemory;
	private long usedPermGen;
	private long maxPermGen;
	private long usedNonHeapMemory;
	private long loadedClassesCount;
	private long availableProcessors;
	private  String javaName;
	private  String javaVersion;
	private  String jvmName;

	private  String jvmVersion;
	private  String jvmArguments;
	private  int threadCount;
	private  int peakThreadCount;
	private  long totalStartedThreadCount;
	private String os;
	public long getUsedMemory() {
		return usedMemory;
	}

	public long getMaxMemory() {
		return maxMemory;
	}

	public long getUsedPermGen() {
		return usedPermGen;
	}


	public long getMaxPermGen() {
		return maxPermGen;
	}


	public long getUsedNonHeapMemory() {
		return usedNonHeapMemory;
	}

	public long getLoadedClassesCount() {
		return loadedClassesCount;
	}


	public long getAvailableProcessors() {
		return availableProcessors;
	}


	public String getJavaVersion() {
		return javaVersion;
	}


	public String getJvmVersion() {
		return jvmVersion;
	}


	public String getJvmArguments() {
		return jvmArguments;
	}


	public int getThreadCount() {
		return threadCount;
	}


	public int getPeakThreadCount() {
		return peakThreadCount;
	}


	public long getTotalStartedThreadCount() {
		return totalStartedThreadCount;
	}


	public String getOs() {
		return os;
	}


	
	public ApplicationMonitor(){
		usedMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024);
		maxMemory = Runtime.getRuntime().maxMemory()/(1024*1024);
		final MemoryPoolMXBean permGenMemoryPool = getPermGenMemoryPool();
		if (permGenMemoryPool != null) {
			final MemoryUsage usage = permGenMemoryPool.getUsage();
			usedPermGen = usage.getUsed()/(1024*1024);
			maxPermGen = usage.getMax()/(1024*1024);
		} else {
			usedPermGen = -1;
			maxPermGen = -1;
		}
		usedNonHeapMemory = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage().getUsed()/(1024*1024);
		loadedClassesCount = ManagementFactory.getClassLoadingMXBean().getLoadedClassCount();
		
		/**
		 * 进程
		 */
		availableProcessors = Runtime.getRuntime().availableProcessors();
		javaName=System.getProperty("java.runtime.name");
		javaVersion =System.getProperty("java.runtime.version");
		jvmName = System.getProperty("java.vm.name");
		jvmVersion=System.getProperty("java.vm.version") + ", " + System.getProperty("java.vm.info");
		jvmArguments = buildJvmArguments();
		
		final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		threadCount = threadBean.getThreadCount();
		peakThreadCount = threadBean.getPeakThreadCount();
		totalStartedThreadCount = threadBean.getTotalStartedThreadCount();
		os = buildOS();
	}
	
	
	private static String buildJvmArguments() {
		final StringBuilder jvmArgs = new StringBuilder();
		for (final String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
			jvmArgs.append(jvmArg).append('\n');
		}
		if (jvmArgs.length() > 0) {
			jvmArgs.deleteCharAt(jvmArgs.length() - 1);
		}
		return jvmArgs.toString();
	}
	
	private static MemoryPoolMXBean getPermGenMemoryPool() {
		for (final MemoryPoolMXBean memoryPool : ManagementFactory.getMemoryPoolMXBeans()) {
			if (memoryPool.getName().endsWith("Perm Gen")) {
				return memoryPool;
			}
		}
		return null;
	}
	
	private static String buildOS() {
		final String name = System.getProperty("os.name");
		final String version = System.getProperty("os.version");
		final String patchLevel = System.getProperty("sun.os.patch.level");
		final String arch = System.getProperty("os.arch");
		final String bits = System.getProperty("sun.arch.data.model");

		final StringBuilder sb = new StringBuilder();
		sb.append(name).append(", ");
		if (!name.toLowerCase(Locale.ENGLISH).contains("windows")) {
			sb.append(version).append(' ');
		}
		if (!"unknown".equals(patchLevel)) {
			sb.append(patchLevel);
		}
		sb.append(", ").append(arch).append('/').append(bits);
		return sb.toString();
	}
	public String getJavaName() {
		return javaName;
	}

	public String getJvmName() {
		return jvmName;
	}


}
