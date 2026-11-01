const QUnit = require("qunit");
const { Converter } = require("../src/converter");

QUnit.module("Converter tests", function() {
    QUnit.test("Setup", function(assert){
        assert.equal(Converter(10), 0);
    });
});