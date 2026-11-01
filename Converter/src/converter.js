function Converter(num){
    if(!Number.isInteger(num)){
        return "NAN";
    }
    if(num <= 0){
        return "NAN";
    }
    if(num >= 4000){
        return "NAN";
    }

    const values = [1000, 500, 100, 50, 10, 5, 1];
    const symbols = ["M", "D", "C", "L", "X", "V", "I"]

    let result = "";

    for(let i = 0; i < values.length; i++){
        while(num >= values[i]){
            result += symbols[i];
            num -= values[i];
        }
    }
    return result;
}

module.exports = { Converter };