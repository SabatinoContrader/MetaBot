/// <reference path="../common/menu-base-model.d.ts" />
import { INotifyPropertyChanged } from '@syncfusion/ej2-base';
import { MenuBase } from '../common/menu-base';
import { FieldSettingsModel } from '../common/menu-base-model';
import { MenuModel } from './menu-model';
/**
 * Specifies the option for orientation mode of Menu. By default, component rendered in Horizontal orientation mode.
 */
export declare type Orientation = 'Horizontal' | 'Vertical';
/**
 * The Menu is a graphical user interface that serve as navigation headers for your application or site.
 * ```html
 * <ul id = 'menu'></ul>
 * ```
 * ```typescript
 * <script>
 * var menuObj = new Menu({ items: [{ text: 'Home' }, { text: 'Contact Us' },{ text: 'Login' }]});
 * menuObj.appendTo("#menu");
 * </script>
 * ```
 */
export declare class Menu extends MenuBase implements INotifyPropertyChanged {
    private tempItems;
    /**
     * Specified the orientation of Menu whether it can be horizontal or vertical.
     * @default 'Horizontal'
     */
    orientation: Orientation;
    /**
     * Specifies the template for Menu item.
     * @default null
     */
    template: string;
    /**
     * Specifies whether to enable / disable the scrollable option in Menu.
     * @default false
     */
    enableScrolling: boolean;
    /**
     * Specifies mapping fields from the dataSource.
     * @default { itemId: "id", text: "text", parentId: "parentId", iconCss: "iconCss", url: "url", separator: "separator",
     * children: "items" }
     */
    fields: FieldSettingsModel;
    /**
     * Constructor for creating the component.
     * @private
     */
    constructor(options?: MenuModel, element?: string | HTMLUListElement);
    /**
     * Get module name.
     * @returns string
     * @private
     */
    protected getModuleName(): string;
    /**
     * For internal use only - prerender processing.
     * @private
     */
    protected preRender(): void;
    protected initialize(): void;
    /**
     * Called internally if any of the property value changed
     * @private
     * @param {MenuModel} newProp
     * @param {MenuModel} oldProp
     * @returns void
     */
    onPropertyChanged(newProp: MenuModel, oldProp: MenuModel): void;
    private createMenuItems;
}
