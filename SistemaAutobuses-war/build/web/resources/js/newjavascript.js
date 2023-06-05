/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

/* global PrimeFaces */

PrimeFaces.validator['emailValidador'] = {
    pattern: /\s+@\S+/,
    validate: function(element, value) {
        if (!this.pattern.test(value)) {
            throw {
                summary: 'Validation Error',
                detail: value + 'no es un email valido.'
            }
        }
    }
}
