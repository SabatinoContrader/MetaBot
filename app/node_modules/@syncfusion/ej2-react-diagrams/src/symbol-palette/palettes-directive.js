var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
import { ComplexBase } from '@syncfusion/ej2-react-base';
/**
 * `Palette` directive represent a axis palette of the react SymbolPalette.
 * It must be contained in a SymbolPalette component(`SymbolPaletteComponent`).
 * ```tsx
 * <SymbolPaletteComponent>
 * <PalettesDirective>
 * <PaletteDirective></PaletteDirective>
 * </PalettesDirective>
 * </SymbolPaletteComponent>
 * ```
 */
var PaletteDirective = /** @class */ (function (_super) {
    __extends(PaletteDirective, _super);
    function PaletteDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    PaletteDirective.moduleName = 'palette';
    return PaletteDirective;
}(ComplexBase));
export { PaletteDirective };
var PalettesDirective = /** @class */ (function (_super) {
    __extends(PalettesDirective, _super);
    function PalettesDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    PalettesDirective.propertyName = 'palettes';
    PalettesDirective.moduleName = 'palettes';
    return PalettesDirective;
}(ComplexBase));
export { PalettesDirective };
