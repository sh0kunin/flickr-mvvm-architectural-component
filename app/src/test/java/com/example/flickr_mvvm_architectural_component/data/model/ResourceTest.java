package com.example.flickr_mvvm_architectural_component.data.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ResourceTest {

	@Test
	public void testResourceSuccess() {
		Resource resource = Resource.success("success");
		assertEquals(LoadingStatus.SUCCESS, resource.getLoadingStatus());
		assertEquals("success", resource.getData());
	}

	@Test
	public void testResourceLoading() {
		Resource resource = Resource.loading("loading");
		assertEquals(LoadingStatus.LOADING, resource.getLoadingStatus());
		assertEquals("loading", resource.getData());
	}

	@Test
	public void testResourceError() {
		Resource resource = Resource.error("Something went wrong", "error");
		assertEquals(LoadingStatus.ERROR, resource.getLoadingStatus());
		assertEquals("error", resource.getData());
		assertEquals("Something went wrong", resource.getErrorMessage());
	}
}
