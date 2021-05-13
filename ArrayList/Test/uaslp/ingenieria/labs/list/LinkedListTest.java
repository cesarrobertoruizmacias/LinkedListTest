package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    //Given_Then_Thas

    @Test
    public void givenAllExistentListsBeforeThisMethod_whenAnotherListIsCreated_ThenListsCountIncrements(){
        LinkedList<Integer> lista = new LinkedList<>();

        int listsCount=LinkedList.getListsCount();

        assertEquals(6,listsCount);
    }
    @Test
    public void whenTheNewLinkedListIsCreated_ThenListIsEmpty(){
        LinkedList<Integer> list = new LinkedList<>();

        int size = list.getSize();

        assertEquals(0,size, "Debe ser 0");
    }

    @Test
    public void givenANewLinkedList_whenAddElement_thenSizeIsOne() throws MyIndexOutOfBoundException {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(100);
        int size = list.getSize();

        assertEquals(1,size, "Debe ser 1");
        assertEquals(100,list.get(0));
    }

    @Test
    public void givenAnExistentListWith1Element_whenAddElement_thenSizeIsTwo() throws MyIndexOutOfBoundException {
        // inicializacion
        LinkedList<Integer> list = new LinkedList<>();

        list.add(500);
        // ejecucion
        list.add(100);
        // validacion
        assertEquals(2,list.getSize(),"Deberia tener 2 elementos");
        assertEquals(500,list.get(0));
        assertEquals(100,list.get(1));
    }


    @Test
    public void givenAnExistentListWithNoCapacity_whenAddElement_thenSizeAndCapacityIncrements() throws MyIndexOutOfBoundException {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);

        assertEquals(5,list.getSize(),"Debería tener 5 elementos");
        assertEquals(500,list.get(0));
        assertEquals(600,list.get(1));
        assertEquals(700,list.get(2));
        assertEquals(800,list.get(3));
        assertEquals(1000,list.get(4));
    }

    @Test
    public void givenAListWith5Element_whenInterator_thenElementsAccesible()  {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);

        Iterator<Integer> it= list.getIterator();

        assertTrue(it.hasNext());
        assertEquals(500,it.next());
        assertTrue(it.hasNext());
        assertEquals(600,it.next());
        assertTrue(it.hasNext());
        assertEquals(700,it.next());
        assertTrue(it.hasNext());
        assertEquals(800,it.next());
        assertTrue(it.hasNext());
        assertEquals(1000,it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void givenAListWith5Element_whenReverseInterator_thenElementsAccesible()  {
        LinkedList<Integer> list=new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);
        list.add(1000);

        Iterator<Integer> it= list.getReverseIterator();

        assertTrue(it.hasNext());
        assertEquals(1000,it.next());
        assertTrue(it.hasNext());
        assertEquals(800,it.next());
        assertTrue(it.hasNext());
        assertEquals(700,it.next());
        assertTrue(it.hasNext());
        assertEquals(600,it.next());
        assertTrue(it.hasNext());
        assertEquals(500,it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void givenAnExistenListWith4Elements_thenDeleteElementHead_thenSizeDecrements()
            throws MyIndexOutOfBoundException {
        //TDD-> Test Driven Development

        LinkedList<Integer> list=new LinkedList<>();
        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(0);

        assertEquals(3,list.getSize(),"Debería tener 3 elementos");
        assertEquals(600,list.get(0));
        assertEquals(700,list.get(1));
        assertEquals(800,list.get(2));
    }

    @Test
    public void givenAnExistenListWith4Elements_thenDeleteElementInTheMiddle_thenSizeDecrements() throws MyIndexOutOfBoundException {
        //TDD-> Test Driven Development

        LinkedList<Integer> list = new LinkedList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(3);

        assertEquals(3,list.getSize(),"Debería tener 3 elementos");
        assertEquals(500,list.get(0));
        assertEquals(600,list.get(1));
        assertEquals(700,list.get(2));
    }

    @Test
    public void givenAnExistenListWith1Elements_thenDeleteA1Element_thenSizeTailHeadIsEmpty() throws MyIndexOutOfBoundException {
        //TDD-> Test Driven Development

        LinkedList<Integer> list = new LinkedList<>();
        list.add(500);
        list.add(600);

        list.delete(1);
        list.delete(0);

        assertEquals(0,list.getSize(),"Debería tener 3 elementos");
        assertEquals(0,list.delete(0));

    }



    @Test
    public void givenAnExistenListWith4Elements_thenDeleteTailElement_thenSizeDecrements() throws MyIndexOutOfBoundException {

        LinkedList<Integer> list=new LinkedList<>();

        list.add(500);
        list.add(600);
        list.add(700);
        list.add(800);

        list.delete(3);

        assertEquals(3,list.getSize(),"Debería tener 3 elementos");
        assertEquals(500,list.get(0));
        assertEquals(600,list.get(1));
        assertEquals(700,list.get(2));
    }

    @Test
    public void givenAnExistentListWithOneElement_whenGetElementAtIndex2_thenMyIndexOutOfBoundsExceptionIsThrown(){
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(6);

        assertThrows(MyIndexOutOfBoundException.class, ()->lista.get(2));
    }

    @Test
    public void givenAnExistentListWithThreeElements_whenDeleteLastElement_thenSizeIsTwo() throws MyIndexOutOfBoundException {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(5);
        lista.add(10);
        lista.add(50);

        lista.delete(2);

        assertEquals(2,lista.getSize());
        assertEquals(5,lista.get(0));
        assertEquals(10,lista.get(1));
    }

    @Test
    public void givenAnExistentListWithThreeElements_whenDeleteElementInTheMiddle_thenSizeIsTwoAndThirdElementIsNowSecondElement() throws MyIndexOutOfBoundException {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(5);
        lista.add(10);
        lista.add(50);

        lista.delete(1);

        assertEquals(2,lista.getSize());
        assertEquals(5,lista.get(0));
        assertEquals(50,lista.get(1));
    }

}


