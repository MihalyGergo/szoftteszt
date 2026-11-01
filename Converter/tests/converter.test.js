const QUnit = require("qunit");
const { Converter } = require("../src/converter");

QUnit.module("Converter tests", function() {
    QUnit.test("Invalid inputs", function(assert){
        assert.equal(Converter("asdasdasd"), "NAN");
        assert.equal(Converter(-12), "NAN");
        assert.equal(Converter(0), "NAN");
        assert.equal(Converter(23.92), "NAN");
        assert.equal(Converter(4000), "NAN");
    });
    QUnit.test("Basic values", function(assert){
        assert.equal(Converter(1), "I");
        assert.equal(Converter(5), "V");
        assert.equal(Converter(10), "X");
        assert.equal(Converter(50), "L");
        assert.equal(Converter(100), "C");
        assert.equal(Converter(500), "D");
        assert.equal(Converter(1000), "M");
    });
});