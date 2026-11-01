const QUnit = require("qunit");
const { Converter } = require("../src/converter");

QUnit.module("Converter tests", function() {
    QUnit.test("Invalid inputs", function(assert){
        assert.equal(Converter("asdasdasd"), "NAN");
        assert.equal(Converter(-12), "NAN");
        assert.equal(Converter(0), "NAN");
        assert.equal(Converter(23.92), "NAN");
    });
});