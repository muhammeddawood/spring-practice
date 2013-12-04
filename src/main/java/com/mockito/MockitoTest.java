package com.mockito;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;

public class MockitoTest {

	public static void main(String[] args) {
		// mock interface
		List mockedList = mock(List.class);
		mockedList.add("one");
		mockedList.clear();
		
		verify(mockedList).clear();
		verify(mockedList).add("one");
		
		// mock concrete class
		LinkedList mockedLinkedList = mock(LinkedList.class);
		when(mockedLinkedList.get(0)).thenReturn("one");
		when(mockedLinkedList.get(1)).thenThrow(new RuntimeException());
		
		System.out.println(mockedLinkedList.get(0));
		//System.out.println(mockedLinkedList.get(1));
		
		// argument matchers
		when(mockedLinkedList.get(anyInt())).thenReturn("element");
		
		
		mockedLinkedList.addAll(Arrays.asList(2, 3));
		verify(mockedLinkedList).addAll(listOfTwoElements());
		
		
		System.out.println(mockedLinkedList.get(anyInt()));
		
	
		mockedLinkedList.add("once");
		
		mockedLinkedList.add("twice");
		mockedLinkedList.add("twice");
		
		mockedLinkedList.add("thrice");
		mockedLinkedList.add("thrice");
		mockedLinkedList.add("thrice");
		
		verify(mockedLinkedList, times(1)).add("once");
		verify(mockedLinkedList, times(2)).add("twice");
		verify(mockedLinkedList, times(3)).add("thrice");
		
		verify(mockedLinkedList, never()).add("never happened");
		
		verify(mockedLinkedList, atLeastOnce()).add("once");
		verify(mockedLinkedList, atLeast(2)).add("twice");
		verify(mockedLinkedList, atMost(5)).add("twice");

		Map mockedMap = mock(Map.class);
		mockedMap.put("test", "best");
		mockedMap.put("test1", "best1");
		//mockedMap.get("test");
		
		InOrder inOrder = inOrder(mockedMap);
		inOrder.verify(mockedMap).put("test1", "best1");
	}
	
	private static List listOfTwoElements() {
		Matcher<List> matcher = new ArgumentMatcher<List>() {

			@Override
			public boolean matches(Object argument) {
				@SuppressWarnings("rawtypes")
				List l = (List)argument;
				return l.size() == 2;
			}
			
		};
		
		return argThat(matcher);
	}

}
