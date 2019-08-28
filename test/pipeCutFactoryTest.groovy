class pipeCutFactoryTest extends GroovyTestCase {

    public void testGetDiameter() {
        def result = ["1.1", "4.4", "6"]
        assertEquals 4.4, result
    }


}
