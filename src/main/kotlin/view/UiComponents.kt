package view

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.*

interface UiComponents {
    val itemDescriptionField : JTextField
    val addItemButton: JButton

    fun openWindow()
}

private const val ADD = "+"
internal class UiComponentsImpl : UiComponents {

    override lateinit var itemDescriptionField: JTextField
    override lateinit var addItemButton: JButton
    private lateinit var contentPanel : JPanel

    init {
        buildUI()
        setStyle()
    }

    override fun openWindow() {
        val frame = JFrame()
        frame.contentPane = contentPanel
        frame.minimumSize = Dimension(600, 800)
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.pack()
        frame.isVisible = true
    }

    private fun buildUI() {
        addContentPanel()
        addItemDescriptionPanel()
        addAddItemButtonPanel()
    }

    private fun addContentPanel() {
        contentPanel = JPanel()
        contentPanel.layout = BoxLayout(contentPanel, BoxLayout.PAGE_AXIS)
    }

    private fun addItemDescriptionPanel() {
        val searchTermPanel = JPanel()
        searchTermPanel.layout = BorderLayout()
        searchTermPanel.maximumSize = Dimension(400, 50)
        itemDescriptionField = JFormattedTextField()
        searchTermPanel.add(itemDescriptionField)
        contentPanel.add(searchTermPanel)
    }

    private fun addAddItemButtonPanel() {
        val searchButtonPanel = JPanel()
        searchButtonPanel.layout = BorderLayout()
        searchButtonPanel.maximumSize = Dimension(400, 50)
        addItemButton = JButton(ADD)
        searchButtonPanel.add(addItemButton)
        contentPanel.add(searchButtonPanel)
    }

    private fun setStyle() {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
    }

}
