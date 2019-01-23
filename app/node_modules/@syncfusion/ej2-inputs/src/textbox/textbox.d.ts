import { Component, EmitType } from '@syncfusion/ej2-base';
import { INotifyPropertyChanged } from '@syncfusion/ej2-base';
import { FloatLabelType } from '../input/input';
import { TextBoxModel } from './textbox-model';
export interface FocusInEventArgs {
    /** Returns the TextBox container element */
    container?: HTMLElement;
    /** Returns the event parameters from TextBox. */
    event?: Event;
    /** Returns the entered value of the TextBox. */
    value?: string;
}
export interface FocusOutEventArgs {
    /** Returns the TextBox container element */
    container?: HTMLElement;
    /** Returns the event parameters from TextBox. */
    event?: Event;
    /** Returns the entered value of the TextBox. */
    value?: string;
}
export interface ChangedEventArgs extends FocusInEventArgs {
    /** Returns the previously entered value of the TextBox. */
    previousValue?: string;
    /** Returns the original event. */
    isInteraction?: boolean;
}
export interface InputEventArgs extends FocusInEventArgs {
    /** Returns the previously updated value of the TextBox. */
    previousValue?: string;
}
/**
 * Represents the TextBox component that allows the user to enter the values based on it's type.
 * ```html
 * <input name='images' id='textbox'/>
 * ```
 * ```typescript
 * <script>
 *   var textboxObj = new TextBox();
 *   textboxObj.appendTo('#textbox');
 * </script>
 * ```
 */
export declare class TextBox extends Component<HTMLInputElement> implements INotifyPropertyChanged {
    private textboxWrapper;
    private l10n;
    private previousValue;
    private cloneElement;
    private globalize;
    /**
     * Specifies the behavior of the TextBox such as text, password, email, etc.
     * @default 'text'
     */
    type: string;
    /**
     * Specifies the boolean value whether the TextBox allows user to change the text.
     * @default false
     */
    readonly: boolean;
    /**
     * Sets the content of the TextBox.
     * @default null
     */
    value: string;
    /**
     * Specifies the floating label behavior of the TextBox that the placeholder text floats above the TextBox based on the below values.
     * Possible values are:
     * * `Never` - The placeholder text should not be float ever.
     * * `Always` - The placeholder text floats above the TextBox always.
     * * `Auto` - The placeholder text floats above the TextBox while focusing or enter a value in Textbox.
     * @default Never
     */
    floatLabelType: FloatLabelType;
    /**
     * Specifies the CSS class value that is appended to wrapper of Textbox.
     * @default ''
     */
    cssClass: string;
    /**
     * Specifies the text that is shown as a hint/placeholder until the user focus or enter a value in Textbox.
     * The property is depending on the floatLabelType property.
     * @default null
     */
    placeholder: string;
    /**
     * Specifies a Boolean value that enable or disable the RTL mode on the Textbox. The content of Textbox
     * display from right to left direction when enable this RTL mode.
     * @default false
     */
    enableRtl: boolean;
    /**
     * Specifies a Boolean value that indicates whether the TextBox allow user to interact with it.
     * @default true
     */
    enabled: boolean;
    /**
     * Specifies a Boolean value that indicates whether the clear button is displayed in Textbox.
     * @default false
     */
    showClearButton: boolean;
    /**
     * Enable or disable persisting TextBox state between page reloads. If enabled, the `value` state will be persisted.
     * @default false
     */
    enablePersistence: boolean;
    /**
     * Triggers when the TextBox component is created.
     * @event
     */
    created: EmitType<Object>;
    /**
     * Triggers when the TextBox component is destroyed.
     * @event
     */
    destroyed: EmitType<Object>;
    /**
     * Triggers when the content of TextBox has changed and gets focus-out.
     * @event
     */
    change: EmitType<ChangedEventArgs>;
    /**
     * Triggers when the TextBox has focus-out.
     * @event
     */
    blur: EmitType<FocusOutEventArgs>;
    /**
     * Triggers when the TextBox gets focus.
     * @event
     */
    focus: EmitType<FocusInEventArgs>;
    /**
     * Triggers each time when the value of TextBox has changed.
     * @event
     */
    input: EmitType<InputEventArgs>;
    constructor(options?: TextBoxModel, element?: string | HTMLInputElement);
    /**
     * Calls internally if any of the property value is changed.
     * @private
     */
    onPropertyChanged(newProp: TextBoxModel, oldProp: TextBoxModel): void;
    /**
     * Gets the component name
     * @private
     */
    getModuleName(): string;
    private isBlank;
    protected preRender(): void;
    private checkAttributes;
    /**
     * To Initialize the control rendering
     * @private
     */
    render(): void;
    private wireEvents;
    private focusHandler;
    private focusOutHandler;
    private inputHandler;
    private changeHandler;
    private raiseChangeEvent;
    private bindClearEvent;
    private resetInputHandler;
    private unWireEvents;
    /**
     * Removes the component from the DOM and detaches all its related event handlers.
     * Also, it maintains the initial TextBox element from the DOM.
     * @method destroy
     * @return {void}
     */
    destroy(): void;
    /**
     * Gets the properties to be maintained in the persisted state.
     * @return {string}
     */
    getPersistData(): string;
    /**
     * Adding the multiple attributes as key-value pair to the TextBox element.
     * @param { { [key: string]: string } } attributes - Specifies the attributes to be add to TextBox element.
     * @return {void}
     */
    addAttributes(attributes: {
        [key: string]: string;
    }): void;
    /**
     * Removing the multiple attributes as key-value pair to the TextBox element.
     * @param { string[] } attributes - Specifies the attributes name to be removed from TextBox element.
     * @return {void}
     */
    removeAttributes(attributes: string[]): void;
}
