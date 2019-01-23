/**
 * Template Engine Bridge
 */
import { compile as render } from './template';
import { createElement } from './dom';
var HAS_ROW = /^[\n\r.]+\<tr|^\<tr/;
var HAS_SVG = /^[\n\r.]+\<svg|^\<path|^\<g/;
/**
 * Compile the template string into template function.
 * @param  {string} templateString - The template string which is going to convert.
 * @param  {Object} helper? - Helper functions as an object.
 * @private
 */
//tslint:disable-next-line
export function compile(templateString, helper) {
    var compiler = engineObj.compile(templateString, helper);
    //tslint:disable-next-line
    return function (data, component, propName) {
        var result = compiler(data, component, propName);
        if (typeof result === 'string') {
            if (HAS_SVG.test(result)) {
                var ele = createElement('svg', { innerHTML: result });
                return ele.childNodes;
            }
            else {
                var ele = createElement((HAS_ROW.test(result) ? 'table' : 'div'), { innerHTML: result });
                return ele.childNodes;
            }
        }
        else {
            return result;
        }
    };
}
/**
 * Set your custom template engine for template rendering.
 * @param  {ITemplateEngine} classObj - Class object for custom template.
 * @private
 */
export function setTemplateEngine(classObj) {
    engineObj.compile = classObj.compile;
}
/**
 * Get current template engine for template rendering.
 * @param  {ITemplateEngine} classObj - Class object for custom template.
 * @private
 */
export function getTemplateEngine() {
    return engineObj.compile;
}
//Default Engine Class
var Engine = /** @class */ (function () {
    function Engine() {
    }
    Engine.prototype.compile = function (templateString, helper) {
        if (helper === void 0) { helper = {}; }
        return render(templateString, helper);
    };
    return Engine;
}());
var engineObj = { compile: new Engine().compile };
